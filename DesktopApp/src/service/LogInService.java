package service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import gui.Main;

public class LogInService {

	
	public Boolean checkCredentials(String username, String password) {
		
		 Integer statusCode =0;
	        try {
	            HttpResponse<JsonNode> loginResult = Unirest.get(Main.URL+Main.logIn_URL+"{credentials}").routeParam("credentials", username +"#" + password).asJson();
	            
	            statusCode = loginResult.getStatus();
	            if(statusCode == 200) {
	            	
	            	return true; //uspjesna prijava
	            }
	        } catch (UnirestException e) {
	            e.printStackTrace();
	        }
	        
	        return false; //neuspjesna prijava
	}
}
