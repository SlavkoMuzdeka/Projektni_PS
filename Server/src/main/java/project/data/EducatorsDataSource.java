package project.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import project.model.Address;
import project.model.Educator;
import project.pool.ConnectionPool;

public class EducatorsDataSource {
	
	private static final String SELECT_ALL = "SELECT * FROM prikaz_vaspitaca";
	private static final String SELECT_ONE = "SELECT * FROM prikaz_vaspitaca WHERE OSOBA_IdOsobe = ?";
	private static final String SELECT_ALL_FROM_GROUP = "{call get_vaspitaci_from_group(?)}";

	private static final String DB_URL = "jdbc:mysql://10.1.0.252:3306/projektni_ps?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static EducatorsDataSource instance = null;

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
	
	public ArrayList<Educator> readAll(){
		ArrayList<Educator> educators = new ArrayList<>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		try {
			c = ConnectionPool.getInstance().checkOut();
			s = c.createStatement();
			rs = s.executeQuery(SELECT_ALL);
			while (rs.next()) {
				Educator e = new Educator();
				e.setId(String.valueOf(rs.getInt(1)));
				e.setName(rs.getString(3));
				e.setSurname(rs.getString(4));
				educators.add(e);
			}
		}catch(Exception ex) {
			return null;
		}finally {
			ConnectionPool.close(c, s, rs);
		}
		return educators;
	}
	
	public Educator readOne(Integer educatorId) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Educator educator = null;
		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(SELECT_ONE);
			ps.setInt(1, educatorId);
			rs = ps.executeQuery();
			if(rs.next()) {
				educator = new Educator();
				educator.setId(String.valueOf(rs.getInt(1)));
				educator.setName(rs.getString(3));
				educator.setSurname(rs.getString(4));
				educator.setDateOfBirth(rs.getDate(5).toString());
				educator.setUid(rs.getString(2));
				
				Address adr = new Address();
				adr.setCity(rs.getString(7));
				adr.setNumber(String.valueOf(rs.getInt(8)));
				adr.setStreet(rs.getString(6));
				educator.setAddress(adr);
			}
		}catch(Exception ex) {
			return null;
		}finally {
			ConnectionPool.close(c, ps, rs);
		}
		return educator;
	}
	
	public ArrayList<Educator> getEducatorsFromGroup(int groupId){
		ArrayList<Educator> educators = new ArrayList<>();
		Connection c = null;
		CallableStatement cs = null;
		ResultSet rs = null;
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
				
				Address adr = new Address();
				adr.setStreet(rs.getString(6));
				adr.setCity(rs.getString(7));
				adr.setNumber(String.valueOf(rs.getInt(8)));
				educator.setAddress(adr);
				educators.add(educator);
			}
		}catch(Exception ex) {
			return null;
		}finally {
			ConnectionPool.close(c,cs,rs);
		}
		return educators;
	}

}
