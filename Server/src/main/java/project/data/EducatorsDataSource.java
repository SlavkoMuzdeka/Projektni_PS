package project.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.text.StyleContext.SmallAttributeSet;

import project.model.Educator;

public class EducatorsDataSource {

	private static final String DB_URL = "jdbc:mysql://10.1.0.74:3306/projektni_ps?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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

}
