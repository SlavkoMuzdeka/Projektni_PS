package project.connectionPool;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
 * Ova klasa je napravljenja sa razlogom da imamo pool konekcija
 * koje se uzimaju prilikom rada sa BP
 * Ovo je napravljeno sa razlogom jer otvaranje svake konekcije, pa nakon toga zatvaranje moze biti vremenski zahtjevno
 * Prilikom testiranja potrebno je samo promijeniti CONFIG_PATH (putanju do konfiguracionog fajla u kom se nalaze odgovarajuci
 * parametri) i pored toga promijeniti u konfiguracionom fajlu jdbcURL (za bazu podataka)
 */
public class ConnectionPool {
	
	private String jdbcURL;
	private String username;
	private String password;
	private int preconnectCount;
	private int maxIdleConnections;
	private int maxConnections;

	private int connectCount;
	private List<Connection> usedConnections;
	private List<Connection> freeConnections;
	
	//Putanja do dataBase.properties
	private static final String CONFIG_PATH = "C:\\Users\\slavko\\Projektovanje\\Projektni_PS\\Server\\resources\\dataBase.properties";

	private static ConnectionPool instance;

	public static ConnectionPool getInstance() {
		if (instance == null)
			instance = new ConnectionPool();
		return instance;
	}

	private ConnectionPool() {
		readConfiguration();
		try {
			freeConnections = new ArrayList<Connection>();
			usedConnections = new ArrayList<Connection>();

			for (int i = 0; i < preconnectCount; i++) {
				Connection conn = DriverManager.getConnection(jdbcURL, username, password);
				freeConnections.add(conn);
			}
			connectCount = preconnectCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readConfiguration() {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(CONFIG_PATH));
			jdbcURL = prop.getProperty("jdbcURL");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			preconnectCount = Integer.parseInt(prop.getProperty("preconnectCount"));
			maxIdleConnections = Integer.parseInt(prop.getProperty("maxIdleConnections"));
			maxConnections = Integer.parseInt(prop.getProperty("maxConnections"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized Connection checkOut() throws SQLException{
		Connection conn = null;
		if (freeConnections.size() > 0) {
			conn = freeConnections.remove(0);
			usedConnections.add(conn);
		} else {
			if (connectCount < maxConnections) {
				conn = DriverManager.getConnection(jdbcURL, username, password);
				usedConnections.add(conn);
				connectCount++;
			} else {
				try {
					wait();
					conn = freeConnections.remove(0);
					usedConnections.add(conn);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return conn;
	}

	public synchronized void checkIn(Connection conn) {
		if (conn == null)
			return;
		if (usedConnections.remove(conn)) {
			freeConnections.add(conn);
			while (freeConnections.size() > maxIdleConnections) {
				int lastOne = freeConnections.size() - 1;
				Connection c = freeConnections.remove(lastOne);
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			notify();
		}
	}
	
}