package service;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import gui.Main;
import model.Address;
import model.Educator;

public class EducatorService implements IServiceable {
	
	
	public static EducatorService instance = null; 

	public static EducatorService getInstance() {
		if (instance == null) {

			return new EducatorService();
		}
		return instance;
	}

	private EducatorService() {
		super();
	}

	@Override
	public Boolean delete(String id) {
		
		  Integer statusCode = 0;
		  try {	
				statusCode = Unirest.delete(Main.URL+Main.children_URL+"{person_id}") .routeParam("person_id", id).asJson().getStatus(); 
				if (statusCode == 200) {
					System.out.println("proslo");
					//Alert za uspjesno dodavanje ovdje
					return true;
				}else {
					//Alert za gresku ovdje
					System.out.println("nije proslo");
				}

			} catch (UnirestException e) {
				e.printStackTrace();
			}
		
		  return false;
	}

	@Override
	public Boolean addOne(Object item) {

		  JSONObject jsonObject = new JSONObject(); String searchQueryApi= Main.URL +  Main.educator_URL;
		  Educator educator= (Educator)item;
		  
		 jsonObject.put("name", educator.getName());
		 jsonObject.put("surname", educator.getSurname());
		 jsonObject.put("uid", educator.getUid());
		 jsonObject.put("dateOfBirth", educator.getDateOfBirth());
		 jsonObject.put("id", educator.getId());
		 Address address = educator.getAddress();
		 jsonObject.put("city", address.getCity());
		 jsonObject.put("street", address.getStreet());
		 jsonObject.put("number", address.getNumber());
		 jsonObject.put("username", educator.getUsername());
		 jsonObject.put("password", educator.getPassword());
		 jsonObject.put("salary", educator.getSalary());
		 jsonObject.put("idGroup", educator.getIdGroup()); 
		  
		  //treba ljekarski i higijenski test Integer statusCode = 0;
		  Integer statusCode = 0;
		  try {	
				statusCode = Unirest.post(searchQueryApi).body(jsonObject.toString().getBytes()).asBinary().getStatus();

				if (statusCode == 200) {
					System.out.println("proslo");
					//Alert za uspjesno dodavanje ovdje
					return true;
				}else {
					//Alert za gresku ovdje
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
			
		JsonNode loginResult;
		JSONObject object = null;
		try {
			loginResult = Unirest.get(Main.URL+Main.children_URL+"{person_id}") .routeParam("person_id", id).asJson().getBody();
	         object = loginResult.getObject();
	        
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	      
           Educator educator = new Educator();
           educator.setId(object.getString("id"));
           educator.setName(object.getString("name"));
           educator.setSurname(object.getString("surname"));
           educator.setDateOfBirth(object.getString("dateOfBirth"));
           educator.setUid(object.getString("uid"));
           educator.setIdGroup(object.getString("idGroup"));
           JSONObject addressObject = object.getJSONObject("address");
           educator.setAddress( new Address(addressObject.getString("city"),  addressObject.getString("street") , addressObject.getString("number")));
           
           return educator;
	}

	@Override
	public Object getAll(String searchString) {
		
		JSONArray jsonArray=null;
		ArrayList<Educator> educatorsList = new ArrayList<>();
		JsonNode loginResult;
		try {
			loginResult = Unirest.get(Main.URL+Main.educator_URL).asJson().getBody();
	        jsonArray = loginResult.getArray();
	        
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		  for (int i = 0; i < jsonArray.length(); i++) {

	            JSONObject object = jsonArray.getJSONObject(i);
	            Educator educator = new Educator();
	            educator.setId(object.getString("id"));
	            educator.setName(object.getString("name"));
	            educator.setSurname(object.getString("surname"));
	            educator.setDateOfBirth(object.getString("dateOfBirth"));
	            educator.setUid(object.getString("uid"));
	            educator.setIdGroup(object.getString("idGroup"));
	            JSONObject addressObject = object.getJSONObject("address");
	            educator.setAddress( new Address(addressObject.getString("city"),  addressObject.getString("street") , addressObject.getString("number")));
	            educatorsList.add(educator);
		 }
		  return educatorsList;
	}

	@Override
	public Boolean edit(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
