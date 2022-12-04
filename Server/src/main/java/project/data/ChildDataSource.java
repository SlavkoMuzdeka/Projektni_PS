package project.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import project.connectionPool.ConnectionPool;
import project.model.Address;
import project.model.Child;

public class ChildDataSource {

	private static final String SELECT_ALL = "SELECT * FROM prikaz_djece";
	private static final String DB_URL = "jdbc:mysql://192.168.43.87:3306/projektni_ps?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static ChildDataSource instance = null;

	public static ChildDataSource getInstance() {
		if (instance == null) {
			instance = new ChildDataSource();
		}
		return instance;
	}

	public Boolean addChildToDb(Child child) {

		Connection c = null;
		CallableStatement cs = null;
		Boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(DB_URL, "root", "Filip123");
			cs = c.prepareCall("{call dodajDijete(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

			cs.setString(1, child.getName());
			cs.setString(2, child.getSurname());
			cs.setString(3, child.getUid());

			String date = child.getDateOfBirth();

			

			cs.setString(4, date);

			cs.setString(5, child.getFatherName());
			cs.setString(6, child.getMotherName());
			cs.setString(7, child.getMotherPhoneNumber());
			cs.setString(8, child.getFatherPhoneNumber());
			cs.setString(9, child.getHeight());
			cs.setString(10, child.getWeight());
			cs.setString(11, child.getAddress().getCity());
			cs.setString(12, child.getAddress().getStreet());
			cs.setString(13, child.getAddress().getNumber());
			cs.setString(14, child.getNote().toString());
			cs.registerOutParameter(15, Types.SMALLINT);

			cs.executeUpdate();

			if ((Integer) cs.getObject(15) == 1) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return result;
	}

	private ChildDataSource() {
		super();
	}
	
	/* Funckija pomocu koje dobijamo listu djece iz baze podataka
	 * Podaci se dobijaju pomocu pogleda prikaz_djece
	 */
	public ArrayList<Child> getChildren(){
		ArrayList<Child> children = new ArrayList<>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		try {
			c = ConnectionPool.getInstance().checkOut();;
			s = c.createStatement();
			rs = s.executeQuery(SELECT_ALL);
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			while (rs.next()) {
				Child child = new Child();
				child.setId(String.valueOf(rs.getInt(1)));
				child.setUid(rs.getString(2));
				child.setName(rs.getString(3));
				child.setSurname(rs.getString(4));
				child.setDateOfBirth(dt.format(rs.getDate(5)).toString());
				child.setAddress(new Address(rs.getString(6), rs.getString(7), String.valueOf(rs.getInt(8))));
				child.setHeight(String.valueOf(rs.getInt(9)));
				child.setWeight(String.valueOf(rs.getInt(10)));
				child.setFatherName(rs.getString(11));
				child.setMotherName(rs.getString(12));
				child.setFatherPhoneNumber(rs.getString(13));
				child.setMotherPhoneNumber(rs.getString(14));
				children.add(child);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(c,s,rs);
		}
		return children;
	}
	
	//Pomocna funckija koja zatvara otvorene resurse
	private static void close(Connection c, Statement s,ResultSet rs) {
		if (s != null) {
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		ConnectionPool.getInstance().checkIn(c);
	}
}
