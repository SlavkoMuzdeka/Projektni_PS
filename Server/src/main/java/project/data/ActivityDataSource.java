package project.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import project.connectionPool.ConnectionPool;
import project.model.Activity;

public class ActivityDataSource {

	private static ActivityDataSource instance = null;
	private static final String SELECT_ALL_FROM_GROUP = "{call get_activities_from_group(?)}";
	
	public ActivityDataSource() {
		super();
	}
	
	public static ActivityDataSource getInstance() {
		if (instance == null) {
			instance = new ActivityDataSource();
		}
		return instance;
	}
	
	//Funkcija pomocu koje dobijamo sve aktivnosti za jednu grupu
	public ArrayList<Activity> getActivitiesFromGroup(int groupId){
		ArrayList<Activity> activities = new ArrayList<>();
		Connection c = null;
		CallableStatement cs = null;
		ResultSet rs =null;
		try {
			c = ConnectionPool.getInstance().checkOut();;
			cs = c.prepareCall(SELECT_ALL_FROM_GROUP);
			cs.setInt(1, groupId);
			rs = cs.executeQuery();
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setId(rs.getInt(1));
				activity.setName(rs.getString(2));
				activity.setDescription(rs.getString(3));
				activity.setDate(dt.format(rs.getDate(4)).toString());
				activity.setDuration(rs.getInt(5));
				activities.add(activity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(c,cs,rs);
		}
		return activities;
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
