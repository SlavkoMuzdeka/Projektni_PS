package project.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import project.model.Child;

public class ChildEvidenceDataSource {

	private static final String DB_URL = "jdbc:mysql://10.1.0.252:3306/projektni_ps?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static ChildEvidenceDataSource instance = null;

	public static ChildEvidenceDataSource getInstance() {
		if (instance == null) {
			instance = new ChildEvidenceDataSource();
		}
		return instance;
	}

	private ChildEvidenceDataSource() {
		super();
	}

	public ArrayList<Child> readAllChildrenFromDB() {
		Connection c;
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<Child> childs = new ArrayList<Child>();

		try {
			
			Class.forName("com.mysql.jdbc.Driver"); 
			c = DriverManager.getConnection(DB_URL, "root", "Filip123");
			ps = c.prepareStatement(
					"select IdOsobe, Ime, Prezime, Prisutno , ImeOca from osoba inner join dijete on IdOsobe=OSOBA_IdOsobe where aktivan is true");
			rs = ps.executeQuery();

			while (rs.next()) {

				Child child = new Child();
				child.setId(rs.getString(1));
				child.setName(rs.getString(2));
				child.setSurname(rs.getString(3));
				child.setIsHere(rs.getBoolean(4));
				child.setFatherName(rs.getString(5));
				childs.add(child);

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

	public boolean updateChildrenToDB(ArrayList<Child> childs) {
		Connection c = null;
		CallableStatement cs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(DB_URL, "root", "Filip123");
			cs = c.prepareCall("{call sacuvaj(?, ?)}");
			for (Child child : childs) {
				cs.setInt(1, Integer.valueOf(child.getId()));
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
