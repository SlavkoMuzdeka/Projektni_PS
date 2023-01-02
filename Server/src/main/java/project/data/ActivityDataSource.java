package project.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import project.model.Activity;
import project.pool.ConnectionPool;

public class ActivityDataSource {
	
	private static ActivityDataSource instance = null;
	
	private static final String SELECT_ALL_FROM_GROUP = "{call get_activities_from_group(?)}";
	
	private ActivityDataSource() {
		super();
	}
	
	public static ActivityDataSource getInstance() {
		if (instance == null) {
			instance = new ActivityDataSource();
		}
		return instance;
	}
	
	public ArrayList<Activity> getActivitiesFromGroup(int groupId){
		ArrayList<Activity> activities = new ArrayList<>();
		Connection c = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			c = ConnectionPool.getInstance().checkOut();;
			cs = c.prepareCall(SELECT_ALL_FROM_GROUP);
			cs.setInt(1, groupId);
			rs = cs.executeQuery();
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setId(rs.getInt(1));
				activity.setName(rs.getString(2));				
				activity.setDescription(rs.getString(3));
							
				activity.setDate(new SimpleDateFormat("dd-MM-yyyy").parse(rs.getDate(4).toString()));
				activities.add(activity);
			}
		} catch (Exception ex) {
			System.out.println("greska glasi : " + ex);
			return null;
		} finally {
			ConnectionPool.close(c, cs, rs);
		}
		return activities;
	}
}
