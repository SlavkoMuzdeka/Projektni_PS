package service;

import java.util.ArrayList;

import org.json.JSONObject;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import gui.Main;
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

	public static boolean addEducator(Educator educator) {
		/*
		 * JSONObject jsonObject = new JSONObject(); String searchQueryApi= Main.URL +
		 * Main.educator_URL;
		 * 
		 * jsonObject.put("name", educator.getName()); jsonObject.put("surname",
		 * educator.getSurname()); jsonObject.put("uid", educator.getUid());
		 * jsonObject.put("dateOfBirth", educator.getDateOfBirth());
		 * jsonObject.put("id", educator.getId()); jsonObject.put("address",
		 * educator.getAddress()); jsonObject.put("username", educator.getUsername());
		 * jsonObject.put("password", educator.getPassword()); jsonObject.put("salary",
		 * educator.getSalary()); jsonObject.put("selectionDate",
		 * educator.getSelectionDate()); jsonObject.put("idGroup",
		 * educator.getIdGroup()); //neki podaci nisu poznati kad se dodaje
		 * jsonObject.put("hygieneTest", higyeneTest);
		 * jsonObject.put("medicalClearance", medicalClearance);
		 * 
		 * //treba ljekarski i higijenski test Integer statusCode = 0;
		 * 
		 * try { statusCode=
		 * Unirest.post(searchQueryApi).body(jsonObject.toString().getBytes()).asBinary(
		 * ).getStatus(); System.out.println("proslo"); }catch(UnirestException e) {
		 * e.printStackTrace(); }
		 * 
		 * if(statusCode == 200) { return true; } return false;
		 */
		return false;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addOne(Object item) {

		/*
		 * JSONObject jsonObject = new JSONObject(); String searchQueryApi= Main.URL +
		 * Main.educator_URL; Educator educator= (Educator)item;
		 * 
		 * jsonObject.put("name", educator.getName()); jsonObject.put("surname",
		 * educator.getSurname()); jsonObject.put("uid", educator.getUid());
		 * jsonObject.put("dateOfBirth", educator.getDateOfBirth());
		 * jsonObject.put("id", educator.getId()); jsonObject.put("address",
		 * educator.getAddress()); jsonObject.put("username", educator.getUsername());
		 * jsonObject.put("password", educator.getPassword()); jsonObject.put("salary",
		 * educator.getSalary()); jsonObject.put("selectionDate",
		 * educator.getSelectionDate()); jsonObject.put("idGroup",
		 * educator.getIdGroup()); //neki podaci nisu poznati kad se dodaje
		 * 
		 * //treba ljekarski i higijenski test Integer statusCode = 0;
		 * 
		 * try { statusCode=
		 * Unirest.post(searchQueryApi).body(jsonObject.toString().getBytes()).asBinary(
		 * ).getStatus(); System.out.println("proslo"); }catch(UnirestException e) {
		 * e.printStackTrace(); }
		 * 
		 * if(statusCode == 200) { return true; } return false;
		 */
		return false;

	}

	@Override
	public Boolean addAll(Object items) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getOne(String id) {

	}

	@Override
	public void getAll(String searchString) {

	}

	@Override
	public Boolean edit(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
