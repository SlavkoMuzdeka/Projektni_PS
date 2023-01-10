package service;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import gui.Main;
import model.ArrivalAndDeparatureTime;


public class ArrivalAndDepartureTimeService {
	
	public static  ArrivalAndDepartureTimeService instance = null;

	public static  ArrivalAndDepartureTimeService getInstance() {
		if (instance == null) {

			return new ArrivalAndDepartureTimeService();
		}
		return instance;
	}
	
	public ArrayList<ArrivalAndDeparatureTime> getArrivalAndDepartureTime(String id) {
		
		 ArrayList<ArrivalAndDeparatureTime>arrivalAndDeparatureTimes= new ArrayList<>();
		  JsonNode loginResult;
		  
		  JSONArray jsonArray = null;
			try {
				loginResult = Unirest.get(Main.URL+Main.arrivalAndDepartureTime_URL+"{child_id}") .routeParam("child_id", id).asJson().getBody(); 
		        jsonArray= loginResult.getArray();
		        
			} catch (UnirestException e) {
				e.printStackTrace();
			}
			
			for(int i=0; i<jsonArray.length(); i++) {
				
				JSONObject object= jsonArray.getJSONObject(i);
				ArrivalAndDeparatureTime arrivalAndDeparatureTime= new ArrivalAndDeparatureTime(object.getString("recordedTime"), object.getBoolean("type"));
				arrivalAndDeparatureTimes.add(arrivalAndDeparatureTime);
			}
			
			return arrivalAndDeparatureTimes;
	}
	
}
