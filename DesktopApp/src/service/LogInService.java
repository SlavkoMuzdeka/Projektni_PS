package service;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import gui.Main;
import model.Account;
import model.Address;
import model.Educator;
import model.Person;

public class LogInService {

	public static LogInService instance = null;

	public static LogInService getInstance() {
		if (instance == null) {

			return new LogInService();
		}
		return instance;
	}
	
	private Account account;
	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Object checkCredentials(String username, String password) {
		
		 Integer statusCode =0;
		 
	        try {
	            HttpResponse<JsonNode> loginResult = Unirest.get(Main.URL+Main.logIn_URL+"{credentials}").routeParam("credentials", username +"#" + password).asJson();
	            
	            statusCode = loginResult.getStatus();
	            if(statusCode == 200) {
	            	
	            	JSONObject jsonObject = loginResult.getBody().getObject();
	            	
	            	account.setIdPerson(jsonObject.getString("idPerson"));
	            	account.setAdministrator(jsonObject.getBoolean("isAdministrator"));
	            	account.setName(jsonObject.getString("name"));
	            	account.setSurname(jsonObject.getString("surname"));
	            	account.setDateOfBirth(jsonObject.getString("dateOfBirth"));
	            	Address address = new Address(jsonObject.getString("city"), jsonObject.getString("street"), jsonObject.getString("number"));
	            	account.setAddress(address);
	            	
	            	return account;
	            	
	            }
	        } catch (UnirestException e) {
	            e.printStackTrace();
	        }
	        
	        return false; 
	}
}
