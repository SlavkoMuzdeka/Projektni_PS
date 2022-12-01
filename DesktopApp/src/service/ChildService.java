package service;

import org.json.JSONObject;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import gui.Main;
import model.Child;

public class ChildService {
	
	
	public static boolean addChild(Child child, byte[] medicalClearance) {
		
		String searchQueryApi= Main.URL + Main.children_URL;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fatherName", child.getFatherName());
		jsonObject.put("motherName", child.getMotherName());
		jsonObject.put("fatherPhoneNumber", child.getFatherPhoneNumber());
		jsonObject.put("motherPhoneNumber", child.getMotherPhoneNumber());
		jsonObject.put("height", child.getHeight());
		jsonObject.put("weight", child.getWeight());
		jsonObject.put("selectionDate", child.getSelectionDate());
		jsonObject.put("name", child.getName());
		jsonObject.put("surname", child.getSurname());
		jsonObject.put("uid", child.getUid());
		jsonObject.put("dateOfBirth", child.getDateOfBirth().toString());
		jsonObject.put("address", child.getAddress());
		jsonObject.put("note", child.getNote());
		jsonObject.put("medicalClearance", medicalClearance);//Provjeriti da li se moze ovako poslati ili treba medicalClearance.toString()

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
