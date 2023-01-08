package project.api;

import javax.ws.rs.PathParam;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import project.model.*;
import project.data.EducatorsDataSource;

@Path("/educators")
public class EducatorsApiService {

	EducatorsDataSource educatorService;

	public EducatorsApiService() {
		educatorService = EducatorsDataSource.getInstance();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response readAll() {
		ArrayList<Educator> educators = educatorService.readAll();
		if(educators != null) {
			return Response.status(200).entity(educators).build();
		}
		return Response.status(404).build();
	}
	
	@GET
	@Path("/{educatorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readOne(@PathParam("educatorId") Integer educatorId) {
		Educator educator = educatorService.readOne(educatorId);
		if(educator != null) {
			return Response.status(200).entity(educator).build();
		}
		return Response.status(404).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEducator(String jsonObject) {
		JSONObject obj = new JSONObject(jsonObject);
		Educator educator = new Educator();
		
		educator.setName(obj.getString("name"));
		educator.setSurname(obj.getString("surname"));
		educator.setUid(obj.getString("uid"));
		educator.setDateOfBirth(obj.getString("dateOfBirth"));
		
		Address adr = new Address();
		adr.setCity(obj.getString("city"));
		adr.setNumber(obj.getString("number"));
		adr.setStreet(obj.getString("street"));
		
		educator.setAddress(adr);
		educator.setUsername(obj.getString("userName"));
		educator.setPassword(obj.getString("password"));
		
		MedicalClearance mc = new MedicalClearance();
		HygieneTest ht = new HygieneTest();
		
		mc.setFile(getMedicalClearance(jsonObject));
		ht.setData(getHygieneTest(jsonObject));
		
		educator.setMedicalClearance(mc);
		educator.setHygieneTest(ht);
		
		if(educatorService.create(educator)) {
			return Response.status(200).build();
		}
		return Response.status(404).build();
	}
	
	private byte[] getMedicalClearance(String jsonObject) {
		JSONObject jObject = new JSONObject(jsonObject);
		JSONArray jArray = jObject.getJSONArray("medicalClearance");
		
		byte[] array = new byte[jArray.length()];
		for(int i = 0; i < jArray.length(); i++) {
		    array[i] = (byte)jArray.getInt(i);
		}
		return array;
	}
	
	private byte[] getHygieneTest(String jsonObject) {
		JSONObject jObject = new JSONObject(jsonObject);
		JSONArray jArray = jObject.getJSONArray("hygieneTest");
		
		byte[] array = new byte[jArray.length()];
		for(int i = 0; i < jArray.length(); i++) {
		    array[i] = (byte)jArray.getInt(i);
		}
		return array;
	}
	
	@GET
	@Path("/{educatorId}/medicalClearance")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicalClearance(@PathParam("educatorId") int educatorId) {
		byte[] data = educatorService.getMedicalClearance(educatorId);
		if(data != null) {
			return Response.status(200).entity(data).build();
		}
		return Response.status(404).build();
	}
	
	@GET
	@Path("/{educatorId}/hygieneTest")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHygieneTest(@PathParam("educatorId") int educatorId) {
		byte[] data = educatorService.getHygieneTest(educatorId);
		if(data != null) {
			return Response.status(200).entity(data).build();
		}
		return Response.status(404).build();
	}
	
	//TODO POTREBNO JE PROMIJENITI PUTANJA ZA PROVJERU KREDENCIJALA
	/*@GET
	@Path("/{educator}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response logIn(@PathParam("educator") String educator) {
		System.out.println(educator);
		String username = educator.split("#")[0];
		String password = educator.split("#")[1];
		Educator e = new Educator();
		e.setUsername(username);
		e.setPassword(password);
		
		if(educatorService.checkValidation(e)) {
			
			return Response.status(Response.Status.OK).build(); // 200
		}
		return Response.status(Response.Status.NO_CONTENT).build(); // 204
	}*/
}
