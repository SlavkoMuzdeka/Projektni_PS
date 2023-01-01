package project.data;

import java.io.ByteArrayInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import project.model.Address;
import project.model.Child;
import project.model.Note;
import project.pool.ConnectionPool;

public class ChildDataSource {
	
	private static final String SELECT_ALL_FROM_GROUP = "{call get_children_from_group(?)}";

	private static final String DB_URL = "jdbc:mysql://10.1.0.252:3306/projektni_ps?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
			cs = c.prepareCall("{call dodajDijete(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

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
			
			ByteArrayInputStream fileInputStream = new ByteArrayInputStream(child.getMedicalClearance().getFile());
			
			//cs.setBinaryStream(15, fileInputStream);
			cs.setString(15,"dojfjw");
			cs.registerOutParameter(16, Types.SMALLINT);

			cs.executeUpdate();

			if ((Integer) cs.getObject(16) == 1) {
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
	
	public Boolean updateChildToDb(Child child) {

		Connection c = null;
		CallableStatement cs = null;
		Boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(DB_URL, "root", "Filip123");
			cs = c.prepareCall("{call updateChild(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			
			
			cs.setInt(1, Integer.parseInt(child.getId()));
			cs.setString(2, child.getName());
			cs.setString(3, child.getSurname());
			cs.setString(4, child.getUid());

			String date = child.getDateOfBirth();

			cs.setString(5, date);

			cs.setString(6, child.getFatherName());
			cs.setString(7, child.getMotherName());
			cs.setString(8, child.getMotherPhoneNumber());
			cs.setString(9, child.getFatherPhoneNumber());
			cs.setString(10, child.getHeight());
			cs.setString(11, child.getWeight());
			cs.setString(12, child.getAddress().getCity());
			cs.setString(13, child.getAddress().getStreet());
			cs.setString(14, child.getAddress().getNumber());
			cs.setString(15, child.getNote().toString());
			
			ByteArrayInputStream fileInputStream = new ByteArrayInputStream(child.getMedicalClearance().getFile());
			
			//cs.setBinaryStream(15, fileInputStream);
			cs.setString(16,"dojfjw");
			cs.registerOutParameter(17, Types.SMALLINT);

			cs.executeUpdate();

			if ((Integer) cs.getObject(17) == 1) {
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

	public boolean deleteChildFromDb(Child child) {
		Connection c = null;
		CallableStatement cs = null;
		Boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(DB_URL, "root", "Filip123");
			cs = c.prepareCall("{call deleteChild(?, ?)}");

			cs.setString(1, child.getId());
			cs.registerOutParameter(2, Types.SMALLINT);

			cs.executeUpdate();

			if ((Integer) cs.getObject(2) == 1) {
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

	public ArrayList<Child> readChildrenFromDb() {
		Connection c;
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<Child> childs = new ArrayList<Child>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(DB_URL, "root", "Filip123");
			ps = c.prepareStatement(
					"select IdOsobe, JMB, Ime, Prezime, DatumRodjenja, Ulica, Grad, Broj, Visina, Tezina, ImeOca, ImeMajke, BrojTelefonaOca, BrojTelefonaMajke, OpisNapomene from osoba inner join dijete on IdOsobe=OSOBA_IdOsobe inner join ADRESA on ADRESA_IdAdrese=IdAdrese left outer join NAPOMENA on DIJETE_OSOBA_IdOsobe=OSOBA_IdOsobe where aktivan is true");
			rs = ps.executeQuery();

			while (rs.next()) {

				Child child = new Child();
				child.setId(rs.getString(1));
				child.setUid(rs.getString(2));
				child.setName(rs.getString(3));
				child.setSurname(rs.getString(4));
				child.setDateOfBirth(rs.getString(5));
				
				Address address = new Address();
				address.setStreet(rs.getString(6));
				address.setCity(rs.getString(7));
				address.setNumber(rs.getString(8));
				
				child.setAddress(address);
				child.setHeight(rs.getString(9));
				child.setWeight(rs.getString(10));
				child.setFatherName(rs.getString(11));
				child.setMotherName(rs.getString(12));
				child.setFatherPhoneNumber(rs.getString(13));
				child.setMotherPhoneNumber(rs.getString(14));
				
				Note note = new Note();
				note.setDescription(rs.getString(15));
								
				child.setNote(note);
				
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

	private ChildDataSource() {
		super();
	}
	
	public ArrayList<Child> getChildrenFromGroup(int groupId){
		ArrayList<Child> children = new ArrayList<>();
		Connection c = null;
		CallableStatement cs = null;
		ResultSet rs =null;
		try {
			c = ConnectionPool.getInstance().checkOut();
			cs = c.prepareCall(SELECT_ALL_FROM_GROUP);
			cs.setInt(1, groupId);
			rs = cs.executeQuery();
			while(rs.next()) {
				Child child = new Child();
				child.setId(rs.getString(1));
				child.setUid(rs.getString(2));
				child.setName(rs.getString(3));
				child.setSurname(rs.getString(4));
				child.setDateOfBirth(rs.getString(5));
				
				Address address = new Address();
				address.setStreet(rs.getString(6));
				address.setCity(rs.getString(7));
				address.setNumber(rs.getString(8));
				
				child.setAddress(address);
				child.setHeight(rs.getString(9));
				child.setWeight(rs.getString(10));
				child.setFatherName(rs.getString(11));
				child.setMotherName(rs.getString(12));
				child.setFatherPhoneNumber(rs.getString(13));
				child.setMotherPhoneNumber(rs.getString(14));
				
				Note note = new Note();
				note.setDescription(rs.getString(15));
								
				child.setNote(note);
				
				children.add(child);
			}
		}catch(Exception ex) {
			return null;
		}finally {
			ConnectionPool.close(c,cs,rs);
		}
		return children;
	}
}
