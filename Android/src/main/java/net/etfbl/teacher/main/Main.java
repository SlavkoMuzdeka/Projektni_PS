package net.etfbl.teacher.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import net.etfbl.teacher.model.Teacher;

public class Main {

	public static final String BASE_URL = "http://localhost:8080/Android/api/teacherLogIn/{userId}";

	public static void main(String[] args) {
		
		Teacher t = new Teacher("1", "marko", "1234");
		JSONObject o = new JSONObject();
		o.put("id", t.getId());
		o.put("username", t.getUsername());
		o.put("password", t.getPassword());
		

		int responseCode = 0;
		try {
			HttpResponse<JsonNode> loginResult = Unirest.get(BASE_URL).routeParam("userId", "marko1#1234").asJson();
		          System.out.println(loginResult.getStatus());
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		

	}
}
