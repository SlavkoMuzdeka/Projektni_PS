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
import project.model.Educator;

public class EducatorsDataSource {

	private static final String DB_URL = "jdbc:mysql://10.1.0.74:3306/projektni_ps?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static EducatorsDataSource instance = null;
	
	private static final String SELECT_ALL = "SELECT * FROM prikaz_vaspitaca";
	private static final String SELECT_ALL_FROM_GROUP = "{call get_vaspitaci_from_group(?)}";
	

	public static EducatorsDataSource getInstance() {
		if (instance == null) {
			instance = new EducatorsDataSource();
		}
		return instance;
	}

	private EducatorsDataSource() {
		super();
	}

	public Boolean checkValidation(Educator educator) {
		Connection c = null;
		CallableStatement cs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(DB_URL, "root", "Filip123");
			cs = c.prepareCall("{call vaspitac_prijava(?, ?, ?)}");
			cs.setString(1, educator.getUsername());
			cs.setString(2, educator.getPassword());
			cs.registerOutParameter(3, Types.INTEGER);
			cs.executeUpdate();
			if ((Integer) cs.getObject(3) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//Funkcija pomocu koje dobijamo listu svih vaspitaca u vrticu
	public ArrayList<Educator> getEducators(){
		ArrayList<Educator> educators = new ArrayList<>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		try {
			c = ConnectionPool.getInstance().checkOut();;
			s = c.createStatement();
			rs = s.executeQuery(SELECT_ALL);
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			while (rs.next()) {
				Educator educator = new Educator();
				educator.setId(String.valueOf(rs.getInt(1)));
				educator.setUid(rs.getString(2));
				educator.setName(rs.getString(3));
				educator.setSurname(rs.getString(4));
				educator.setDateOfBirth(dt.format(rs.getDate(5)).toString());
				educator.setAddress(new Address(rs.getString(6), rs.getString(7), String.valueOf(rs.getInt(8))));
				educators.add(educator);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(c,s,rs);
		}
		return educators;
	}
	
	//Funckija pomocu koje dobijamo listu vaspitaca iz tacno odredjene grupe
	public ArrayList<Educator> getEducatorsFromGroup(int groupId){
		ArrayList<Educator> educators = new ArrayList<>();
		Connection c = null;
		CallableStatement cs = null;
		ResultSet rs =null;
		try {
			c = ConnectionPool.getInstance().checkOut();
			cs = c.prepareCall(SELECT_ALL_FROM_GROUP);
			cs.setInt(1, groupId);
			rs = cs.executeQuery();
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			while(rs.next()) {
				Educator educator = new Educator();
				educator.setId(String.valueOf(rs.getInt(1)));
				educator.setUid(rs.getString(2));
				educator.setName(rs.getString(3));
				educator.setSurname(rs.getString(4));
				educator.setDateOfBirth(dt.format(rs.getDate(5)).toString());
				educator.setAddress(new Address(rs.getString(6), rs.getString(7), String.valueOf(rs.getInt(8))));
				educators.add(educator);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			close(c,cs,rs);
		}
		return educators;
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
