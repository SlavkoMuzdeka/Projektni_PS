package service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import gui.Main;
import model.Address;
import model.Child;
import model.Note;

public class ChildService implements IServiceable {

	public static ChildService instance = null;

	public static ChildService getInstance() {
		if (instance == null) {

			return new ChildService();
		}
		return instance;
	}

	private ChildService() {
		super();
	}

	@Override
	public Boolean delete(String id) {
		
		return null;
		
	}

	@Override
	public Boolean addOne(Object item) {

		String searchQueryApi = Main.URL + Main.children_URL;
		Child child = (Child) item;
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
		Address address = child.getAddress();
		jsonObject.put("city", address.getCity());
		jsonObject.put("street", address.getStreet());
		jsonObject.put("number", address.getNumber());
		Note note = child.getNote();
		jsonObject.put("description", note.getDescription());
		jsonObject.put("medicalClearance", child.getMedicalClearance().getFile());

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getAll(String searchString) {
		
		JSONArray jsonArray=null;
		ArrayList<Child> childrenList = new ArrayList<>();
		JsonNode loginResult;
		try {
			loginResult = Unirest.get(Main.URL+Main.children_URL).asJson().getBody();
			System.out.println("ddd");
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
            child.setFatherName(object.getString("fatherName"));
            child.setDateOfBirth(object.getString("dateOfBirth"));
            child.setMotherName(object.getString("motherName"));
            child.setMotherPhoneNumber(object.getString("motherPhoneNumber"));
            child.setFatherPhoneNumber(object.getString("fatherPhoneNumber"));
            JSONObject addressObject = object.getJSONObject("address");
          child.setAddress( new Address(addressObject.getString("city"),  addressObject.getString("street") , addressObject.getString("number")));
            child.setHeight(object.getString("height"));
      //      object.get
            child.setWeight(object.getString("weight"));
            JSONObject noteObject = object.getJSONObject("note");
            child.setNote(new Note(noteObject.getString("description")));
            childrenList.add(child);
        }
		
        return childrenList;
	}

	@Override
	public Boolean edit(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
