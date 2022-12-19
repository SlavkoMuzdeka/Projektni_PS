package service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import gui.Main;
import model.Activity;
import model.Child;

public class ActivityService implements IServiceable{

	public static ActivityService instance = null;

	public static ActivityService getInstance() {
		if (instance == null) {

			return new ActivityService();
		}
		return instance;
	}
	
	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addOne(Object item) {
		
		String searchQueryApi = Main.URL + Main.activity_URL;
		Activity activity = (Activity) item;
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("date", activity.getDate());
		jsonObject.put("name", activity.getName());
		jsonObject.put("description", activity.getDescription());
		//period na sta se odnosi
		jsonObject.put("idGroup", activity.getIdGroup());
		
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
	public Object getAll(String idGroup) {
		
		 ArrayList<Activity> activityList = new ArrayList<>();
		  JsonNode loginResult;
		  JSONArray jsonArray= null;
			try {
				loginResult = Unirest.get(Main.URL+Main.activity_URL+"{group_id}") .routeParam("group_id", idGroup).asJson().getBody(); //provjeriti
		        jsonArray= loginResult.getArray();
		        
			} catch (UnirestException e) {
				e.printStackTrace();
			}
			
			   for (int i = 0; i < jsonArray.length(); i++) {
				   
				   JSONObject object = jsonArray.getJSONObject(i);
				   
				   Activity activity = new Activity();
				   activity.setDate(object.getString("date"));
				   activity.setName(object.getString("name"));
				   activity.setDescription(object.getString("description")); 
				   activityList.add(activity);
			   }
			   
			   return activityList;
	}

	@Override
	public Boolean edit(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
