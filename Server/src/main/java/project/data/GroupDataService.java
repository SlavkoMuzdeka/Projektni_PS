package project.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import project.model.Activity;
import project.model.Child;
import project.model.Educator;
import project.model.Group;
import project.pool.ConnectionPool;

public class GroupDataService {
	
	private static final String SELECT_ALL = "SELECT * FROM grupa";
	private static final String SELECT_ONE = "SELECT * FROM grupa WHERE IdGrupe = ?";
	private static final String INSERT_INTO_GROUP = "{call add_person_to_group(?, ?, ?, ?)}";
	private static final String DELETE_FROM_GROUP = "{call delete_person_from_group(?, ?, ?, ?)}";
	
	private static GroupDataService instance = null;
	
	private ChildDataSource childService = ChildDataSource.getInstance();//Potrebna referenca kako bismo dobili svu djecu iz odgovarajuce grupe
	private EducatorsDataSource educatorService = EducatorsDataSource.getInstance();//Potrebna referenca kako bismo dobili sve vaspitace iz odgovarajuce grupe
	private ActivityDataSource activityService = ActivityDataSource.getInstance();
	
	public static GroupDataService getIstance() {
		if (instance == null) {
			instance = new GroupDataService();
		}
		return instance;
	}
	
	public ArrayList<Group> readAll(){
		ArrayList<Group> groups = new ArrayList<>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		try {
			c = ConnectionPool.getInstance().checkOut();
			s = c.createStatement();
			rs = s.executeQuery(SELECT_ALL);
			while (rs.next()) {
				Group group = new Group();
				group.setId(rs.getInt(1));
				group.setName(rs.getString(2));
				group.setNumberOfMembers(rs.getInt(3));
				groups.add(group);
			}
		}catch(Exception ex) {
			return null;
		}finally {
			ConnectionPool.close(c, s, rs);
		}
		return groups;
	}

	public Group readOne(Integer groupId) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Group group = null;
		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(SELECT_ONE);
			ps.setInt(1, groupId);
			rs = ps.executeQuery();
			if(rs.next()) {
				ArrayList<Child> children = childService.getChildrenFromGroup(groupId);
				ArrayList<Educator> educators = educatorService.getEducatorsFromGroup(groupId);
				ArrayList<Activity> activities = activityService.getActivitiesFromGroup(groupId);
				group = new Group(rs.getInt(1), rs.getString(2), rs.getInt(3), children, educators, activities);
			}
		}catch(Exception ex) {
			return null;
		}finally {
			ConnectionPool.close(c, ps, rs);
		}
		return group;
	}
	
	public Boolean insertIntoGroup(int groupId, int personId, boolean type) {
		Connection c = null;
		CallableStatement cs = null;
		try {
			c = ConnectionPool.getInstance().checkOut();
			cs = c.prepareCall(INSERT_INTO_GROUP);
			cs.setInt(1, personId);
			cs.setInt(2, groupId);
			if(type) {
				cs.setInt(3, 0);
			}else {
				cs.setInt(3, 1);
			}
			cs.registerOutParameter(4, Types.BOOLEAN);
			cs.executeUpdate();
			return cs.getBoolean(4);
		}catch(Exception ex) {
			return false;
		}finally {
			ConnectionPool.close(c, cs, null);
		}
	}
	
	public Boolean deleteFromGroup(int groupId, int personId, boolean type) {
		Connection c = null;
		CallableStatement cs = null;
		try {
			c = ConnectionPool.getInstance().checkOut();
			cs = c.prepareCall(DELETE_FROM_GROUP);
			cs.setInt(1, personId);
			cs.setInt(2, groupId);
			if(type) {
				cs.setInt(3, 0);
			}else {
				cs.setInt(3, 1);
			}
			cs.registerOutParameter(4, Types.BOOLEAN);
			cs.executeUpdate();
			return cs.getBoolean(4);
		}catch(Exception ex) {
			return false;
		}finally {
			ConnectionPool.close(c, cs, null);
		}
	}
	
}
