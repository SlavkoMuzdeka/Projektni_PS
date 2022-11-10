package net.etfbl.child.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.etfbl.child.model.DataSource;

public class DataSource {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/projektni_ps?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static DataSource instance = null;

	public static DataSource getInstance() {
		if (instance == null) {
			instance = new DataSource();
		}
		return instance;
	}

	private DataSource() {
		super();
	}

	public ArrayList<Child> readAllChildsFromDB() {
		Connection c;
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<Child> childs = new ArrayList<Child>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(DB_URL, "newuser", "Magla123");
			ps = c.prepareStatement(
					"select Ime, Prezime, Tip, EvidentiranoVrijeme, max(IdVremenaDolaskaIOdlaska) from ((osoba inner join dijete on IdOsobe=OSOBA_IdOsobe) left outer join vrijeme_dolaska_i_odlaska on OSOBA_IdOsobe=DIJETE_OSOBA_IdOsobe) group by IdOsobe");
			rs = ps.executeQuery();

			while (rs.next()) {
				childs.add(new Child(rs.getString(1), "null", rs.getString(2), rs.getBoolean(3)));

			}

			ps.close();
			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return childs;
	}

}
