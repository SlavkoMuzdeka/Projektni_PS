package service;

import org.json.JSONObject;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import gui.Main;
import model.Child;

public class ChildService {
	
	
	public static boolean addChild(Child child) {
		
		String searchQueryApi= Main.URL + Main.children_URL;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fatherName", child.getFatherName());
		jsonObject.put("motherName", child.getMotherName());
		jsonObject.put("fatherPhoneNumber", child.getFatherPhoneNumber());
		jsonObject.put("motherPhoneNumber", child.getMotherPhoneNumber());
		jsonObject.put("height", child.getHeight());
		jsonObject.put("weight", child.getWeight());
		jsonObject.put("selectionDate", child.getSelectionDate());
		jsonObject.put("idGroup", child.getIdGroup());
		jsonObject.put("name", child.getName());
		jsonObject.put("surname", child.getSurname());
		jsonObject.put("uid", child.getUid());
		jsonObject.put("dateOfBirth", child.getDateOfBirth().toString());
		jsonObject.put("id", child.getId());
		jsonObject.put("address", child.getAddress());
		jsonObject.put("note", child.getNote());
		//ljekarsko parsiram fajl 
		
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
