package service;

import org.json.JSONObject;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import gui.Main;
import model.Educator;

public class EducatorService {

	public static boolean addEducator(Educator educator, byte[] higyeneTest, byte[] medicalClearance) {
		
		JSONObject jsonObject = new JSONObject();
		String searchQueryApi= Main.URL + Main.educator_URL;
		
		jsonObject.put("name", educator.getName());
		jsonObject.put("surname", educator.getSurname());
		jsonObject.put("uid", educator.getUid());
		jsonObject.put("dateOfBirth", educator.getDateOfBirth());
		jsonObject.put("address", educator.getAddress());
		jsonObject.put("username", educator.getUsername());
	    jsonObject.put("password", educator.getPassword());
	    jsonObject.put("salary", educator.getSalary());
	    jsonObject.put("idGroup", educator.getIdGroup());
		jsonObject.put("hygieneTest", higyeneTest);
		jsonObject.put("medicalClearance", medicalClearance);
		
	    Integer statusCode = 0;
		
		try {
			statusCode= Unirest.post(searchQueryApi).body(jsonObject.toString().getBytes()).asBinary().getStatus();
			System.out.println("proslo");
		}catch(UnirestException e) {
			e.printStackTrace();
		}
		
		if(statusCode == 200) {
			return true;
		}
		return false;	
	}
}
