package net.etfbl.child.main;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import net.etfbl.teacher.model.Teacher;

public class Main1 {

	public static final String BASE_URL = "http://localhost:8080/Android/api/childEvidence/";

	public static void main(String[] args) {
		
		
		try {
			JsonNode loginResult = Unirest.get(BASE_URL).asJson().getBody();
			JSONArray jsonArray = loginResult.getArray();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				System.out.println(obj.get("name") + " " + obj.getString("surname"));
			}
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		

	}
}
