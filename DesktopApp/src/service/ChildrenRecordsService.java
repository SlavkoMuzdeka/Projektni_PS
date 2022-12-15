package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import gui.Main;
import model.ArrivalAndDeparatureTime;
import model.Child;


public class ChildrenRecordsService implements IServiceable {

	@Override
	public Boolean addAll(Object items) {   //ako se posalje lista u kojoj su vec smjesteni podaci isHere
		
		String searchQueryApi = Main.URL+Main.children_URL;  // putanja?
        JSONArray jsonArray = new JSONArray();
        List<Object> childrenList = Arrays.asList((Object[])items);
        for(int i=0; i<childrenList.size(); i++){
        	
            JSONObject object = new JSONObject();
            Child child = (Child) childrenList.get(i);
            try {
                object.put("id", child.getId());
                object.put("isHere", child.getIsHere());
                jsonArray.put(object);
            }catch (JSONException e){
                e.printStackTrace();
            }

        }
		Integer statusCode = 0;
		try {
			
			statusCode = Unirest.post(searchQueryApi).body(jsonArray.toString().getBytes()).asBinary().getStatus();

			if (statusCode == 200) {
				return true;
			}

		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Object getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getAll(String searchString) {
		
		 JSONArray jsonArray=null;
		ArrayList<Child> childrenList = new ArrayList<>();
	        try {
	            JsonNode loginResult = Unirest.get(Main.URL+Main.children_URL).asJson().getBody(); //putanja?
	            jsonArray = loginResult.getArray();

	        } catch (UnirestException e) {
	            e.printStackTrace();
	        }
	        
	        for (int i = 0; i < jsonArray.length(); i++) {

	            JSONObject object = jsonArray.getJSONObject(i);
	            Child child = new Child();
	            child.setId(object.getString("id"));
	            child.setName(object.getString("name"));
	            child.setSurname(object.getString("surname"));
	            child.setIdGroup(object.getString("idGroup"));
	            child.setDateOfBirth(object.getString("dateOfBirth"));
	            child.setArrivalAndDeparatureTime(new ArrivalAndDeparatureTime(object.getString("recordedTime"), object.getBoolean("type")));
	            child.setIsHere(object.getBoolean("isHere"));
	            childrenList.add(child);
	        }
	        return childrenList;
	}

	@Override
	public Boolean edit(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addOne(Object item) {
		// TODO Auto-generated method stub
		return null;
	}
}
