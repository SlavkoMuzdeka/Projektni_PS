package service;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import gui.Main;
import model.Group;

public class GroupService implements IServiceable{

	
	public static GroupService instance = null;

	public static GroupService getInstance() {
		if (instance == null) {

			return new GroupService();
		}
		return instance;
	}
	
	@Override
	public Boolean delete(String id) {
		  Integer statusCode = 0;
		  try {	
				statusCode = Unirest.delete(Main.URL+Main.group_URL+"{group_id}") .routeParam("group_id", id).asJson().getStatus(); 
				if (statusCode == 200) {
					return true;
				}
			} catch (UnirestException e) {
				e.printStackTrace();
			}	
		  return false;
	}

	@Override
	public Boolean addOne(Object item) {
		
		String searchQueryApi = Main.URL + Main.group_URL;
		Group group = (Group) item;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", group.getName());

		Integer statusCode = 0;
		try {
			
			statusCode = Unirest.post(searchQueryApi).body(jsonObject.toString().getBytes()).asBinary().getStatus();

			if (statusCode == 200) {
				return true;
			}

		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return false;
		
	}

	@Override
	public Boolean addAll(Object items) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getAll(String searchString) {
		
		JSONArray jsonArray=null;
		ArrayList<Group> groupsList = new ArrayList<>();
		JsonNode loginResult;
		try {
			loginResult = Unirest.get(Main.URL+Main.group_URL).asJson().getBody();
	        jsonArray = loginResult.getArray();
	        
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < jsonArray.length(); i++) {

	         JSONObject object = jsonArray.getJSONObject(i);
	         Group group = new Group();
	         
	         group.setName(object.getString("name"));
	         group.setId(object.getString("id"));

	         groupsList.add(group);
	         
		}
		
		return groupsList;
	}

	@Override
	public Boolean edit(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
