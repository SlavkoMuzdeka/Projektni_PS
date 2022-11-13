package net.etfbl.child.main;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.options.Option;
import com.mashape.unirest.http.options.Options;

import net.etfbl.child.model.Child;
import net.etfbl.teacher.model.Teacher;

public class Main1 {

	public static final String BASE_URL = "http://localhost:8080/Android/api/childEvidence/";

	public static void main(String[] args) {

		try {
			ArrayList<Child> childs = new ArrayList<Child>();

			JsonNode loginResult = Unirest.get(BASE_URL).asJson().getBody();
			JSONArray jsonArray = loginResult.getArray();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				System.out.println(obj.get("name") + " " + obj.getString("surname"));
				childs.add(new Child((Integer)obj.get("id"), (String)obj.get("name"), (String)obj.get("parentName"), (String)obj.get("surname"), (Boolean)obj.get("isHere")));
			}
			
			
			childs.get(0).setIsHere(false);
			childs.get(1).setIsHere(false);
			JSONArray jsonArray1 = new JSONArray(childs);
			
			System.out.println(childs);
			System.out.println(jsonArray1);
		//	int status = Unirest.put(BASE_URL).body(jsonArray1.toString().getBytes()).asBinary().getStatus();
			
			
			//System.out.println(status);

		} catch (UnirestException e) {
			e.printStackTrace();
		}

	}
}
