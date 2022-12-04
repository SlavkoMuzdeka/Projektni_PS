package project.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import project.connectionPool.ConnectionPool;
import project.model.Activity;
import project.model.Child;
import project.model.Educator;
import project.model.Group;

public class GroupDataSource {

	private static GroupDataSource instance = null;
	private ChildDataSource childService = ChildDataSource.getInstance();//Potrebna referenca kako bismo dobili svu djecu iz odgovarajuce grupe
	private EducatorsDataSource educatorService = EducatorsDataSource.getInstance();//Potrebna referenca kako bismo dobili sve vaspitace iz odgovarajuce grupe
	private ActivityDataSource activityService = ActivityDataSource.getInstance();
	
	private static final String SELECT_ALL = "SELECT * FROM grupa";
	
	public GroupDataSource() {
		super();
	}
	
	public static GroupDataSource getInstance() {
		if (instance == null) {
			instance = new GroupDataSource();
		}
		return instance;
	}
	
	/*
	 * Funckija pomocu koje dobijamo listu svih grupa, pri cemu se prenose informacije o tome
	 * ko su clanove te grupe kao i koje aktivnosti su vezane za tu grupu
	 */
	public ArrayList<Group> getGroups(){
		ArrayList<Group> groups = new ArrayList<>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		try {
			c = ConnectionPool.getInstance().checkOut();;
			s = c.createStatement();
			rs = s.executeQuery(SELECT_ALL);
			while (rs.next()) {
				int groupId = rs.getInt(1);
				ArrayList<Child> children = childService.getChildrenFromGroup(groupId);
				ArrayList<Educator> educators = educatorService.getEducatorsFromGroup(groupId);
				ArrayList<Activity> activities = activityService.getActivitiesFromGroup(groupId);
				Group group = new Group(rs.getInt(1), rs.getString(2), rs.getInt(3), children, educators, activities);
				groups.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(c,s,rs);
		}
		return groups;
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
