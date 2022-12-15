package service;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import gui.Main;
import model.Bill;


public class MonthlyExpensesService implements IServiceable {

	public static MonthlyExpensesService instance = null;

	public static MonthlyExpensesService getInstance() {
		if (instance == null) {

			return new MonthlyExpensesService();
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
		
		String searchQueryApi = Main.URL + Main.monthlyExpenses_URL;
		Bill bill = (Bill) item;
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("billNumber", bill.getBillNumber()); 
		jsonObject.put("billType", bill.getBillType());
		jsonObject.put("amount", bill.getAmount());
		jsonObject.put("date", bill.getDate());
		jsonObject.put("paid", bill.isPaid());
		jsonObject.put("kindergartenName", bill.getKindergartenName());
		
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
		ArrayList<Bill> billsList = new ArrayList<>();
		JsonNode loginResult;
		try {
			loginResult = Unirest.get(Main.URL+Main.monthlyExpenses_URL).asJson().getBody();
	        jsonArray = loginResult.getArray();
	        
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		 for (int i = 0; i < jsonArray.length(); i++) {

	            JSONObject object = jsonArray.getJSONObject(i);
	           Bill bill = new Bill();
	            bill.setBillNumber(object.getString("billNumber"));
	            bill.setBillType(object.getString("billType"));
	            bill.setAmount(object.getInt("amount"));
	            bill.setDate(object.getString("date"));
	            bill.setPaid(object.getBoolean("paid"));
	            bill.setKindergartenName(object.getString("kindergartenName"));
	            
	            billsList.add(bill);
		 }
		 
		 return billsList;
	}

	@Override
	public Boolean edit(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
