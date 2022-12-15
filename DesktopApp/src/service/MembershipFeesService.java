package service;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import gui.Main;
import model.Membership;

public class MembershipFeesService implements IServiceable{
	
	public static MembershipFeesService instance = null;

	public static MembershipFeesService getInstance() {
		if (instance == null) {

			return new MembershipFeesService();
		}
		return instance;
	}
	
	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addOne(Object item) {
		String searchQueryApi = Main.URL + Main.membershipFees_URL;
		Membership membership = (Membership) item;
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("serviceType", membership.getServiceType()); 
		jsonObject.put("amount", membership.getAmount());
		jsonObject.put("paymentDate",membership.getPaymentDate());
		jsonObject.put("date", membership.getDate());
		jsonObject.put("paid", membership.isPaid());
		jsonObject.put("idChild" , membership.getIdChild()); //provjeriti
		
		Integer statusCode = 0;

		try {
			
			statusCode = Unirest.post(searchQueryApi).body(jsonObject.toString().getBytes()).asBinary().getStatus();
			if (statusCode == 200) {
				return true;
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
		ArrayList<Membership> membershipsList = new ArrayList<>();
		JsonNode loginResult;
		try {
			loginResult = Unirest.get(Main.URL+Main.membershipFees_URL).asJson().getBody();
	        jsonArray = loginResult.getArray();
	        
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		
		 for (int i = 0; i < jsonArray.length(); i++) {

	            JSONObject object = jsonArray.getJSONObject(i);
	            Membership membership = new Membership();
	            membership.setServiceType(object.getString("serviceType")); 
	            membership.setPaid(object.getBoolean("paid"));
	            membership.setDate(object.getString("date"));
	            membership.setAmount(object.getInt("amount"));
	            membership.setPaymentDate(object.getString("paymentDate"));
	            //treba jos ime i prezime djeteta kako tome pristupiti preko id ili da bude Child u klasi Membership
	            //mjesec postoji na gui-ju ali ne bazi
	            membershipsList.add(membership);
		 }
		 
		 return membershipsList;
	}

	@Override
	public Boolean edit(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
