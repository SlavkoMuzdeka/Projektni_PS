package net.etfbl.child.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
					"select IdOsobe, Ime, Prezime, Prisutan from osoba inner join dijete on IdOsobe=OSOBA_IdOsobe");
			rs = ps.executeQuery();

			while (rs.next()) {
				childs.add(new Child(rs.getInt(1), rs.getString(2), "null", rs.getString(3), rs.getBoolean(4)));

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

	public boolean updateChildToDB(ArrayList<Child> childs) {
		Connection c = null;
		CallableStatement cs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(DB_URL, "newuser", "Magla123");
			cs = c.prepareCall("{call sacuvaj(?, ?)}");
			for (Child child : childs) {
				cs.setInt(1, child.getId());
				cs.setBoolean(2, child.getIsHere());
				cs.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
