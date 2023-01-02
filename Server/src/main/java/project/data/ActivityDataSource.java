package project.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import project.model.Activity;
import project.pool.ConnectionPool;

public class ActivityDataSource {
	
	private static ActivityDataSource instance = null;
	
	private static final String SELECT_ALL_FROM_GROUP = "{call get_activities_from_group(?)}";
	private static final String CREATE_ACTIVITY = "{call create_activity(?, ?, ?, ?)}";
	
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
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setId(rs.getInt(1));
				activity.setName(rs.getString(2));				
				activity.setDescription(rs.getString(3));
							
				activity.setDate(dt.format(rs.getDate(4)));
				activities.add(activity);
			}
		} catch (Exception ex) {
			return null;
		} finally {
			ConnectionPool.close(c, cs, rs);
		}
		return activities;
	}
	
	public int createActivity(String name, String description) {
		Connection c = null;
		CallableStatement cs = null;
		try {
			c = ConnectionPool.getInstance().checkOut();
			cs = c.prepareCall(CREATE_ACTIVITY);
			cs.setString(1, name);
			cs.setString(2, description);
			cs.registerOutParameter(3, Types.BOOLEAN);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.executeUpdate();
			if(cs.getBoolean(3) == true) {
				return cs.getInt(4);
			}
		}catch(Exception ex) {
			return 0;
		}finally {
			ConnectionPool.close(c, cs, null);
		}
		return 0;
	}
}
