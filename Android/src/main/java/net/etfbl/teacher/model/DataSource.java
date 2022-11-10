package net.etfbl.teacher.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.text.StyleContext.SmallAttributeSet;

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

	public Boolean checkValidation(Teacher teacher) {
		Connection c = null;
		CallableStatement cs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(DB_URL, "newuser", "Magla123");
			cs = c.prepareCall("{call vaspitac_prijava(?, ?, ?)}");
			cs.setString(1, teacher.getUsername());
			cs.setString(2, teacher.getPassword());
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

}
