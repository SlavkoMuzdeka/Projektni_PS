package project.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import project.data.ChildDataSource;
import project.data.ChildEvidenceDataSource;
import project.model.Address;
import project.model.Child;
import project.model.Note;

@Path("/children")
public class ChildApiService {
	
	ChildDataSource dataService;

	public ChildApiService() {
		dataService = ChildDataSource.getInstance();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response writeOne(String jsonObject) {
		
		JSONObject jsObject = new JSONObject(jsonObject);

		Address address = new Address();
		address.setStreet(jsObject.getString("street"));
		address.setCity(jsObject.getString("city"));
		address.setNumber(jsObject.getString("number"));
		
		Note note = new Note();
		note.setDescription("sadgasgjvdj");
		note.setDescription(jsObject.getString("description"));

		Child child = new Child();
		child.setName(jsObject.getString("name"));
		child.setSurname(jsObject.getString("surname"));
		child.setUid(jsObject.getString("uid"));
		child.setDateOfBirth(jsObject.getString("dateOfBirth"));
		child.setAddress(address);
		child.setFatherName(jsObject.getString("fatherName"));
		child.setMotherName(jsObject.getString("motherName"));
		child.setFatherPhoneNumber(jsObject.getString("fatherPhoneNumber"));
		child.setMotherPhoneNumber(jsObject.getString("motherPhoneNumber"));
		child.setHeight(jsObject.getString("height"));
		child.setWeight(jsObject.getString("weight"));
		child.setNote(note);
		
		if(dataService.addChildToDb(child)) {
			return Response.status(Response.Status.OK).build();
		}else {
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		
	}
	
}
