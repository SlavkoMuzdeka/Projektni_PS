package project.api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import project.data.ChildDataSource;
import project.model.Address;
import project.model.Child;
import project.model.MedicalClearance;
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
		
		MedicalClearance medicalClearance = new MedicalClearance();
		medicalClearance.setFile(jsObject.getString("medicalClearance").getBytes());
		child.setMedicalClearance(medicalClearance);
		child.setNote(note);
		

		if (dataService.addChildToDb(child)) {
			return Response.status(Response.Status.OK).build();
		} else {
			return Response.status(Response.Status.NO_CONTENT).build();
		}

	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateOne(String jsonObject) {

		JSONObject jsObject = new JSONObject(jsonObject);

		Address address = new Address();
		address.setStreet(jsObject.getString("street"));
		address.setCity(jsObject.getString("city"));
		address.setNumber(jsObject.getString("number"));

		Note note = new Note();
		note.setDescription("sadgasgjvdj");
		note.setDescription(jsObject.getString("description"));

		Child child = new Child();
		child.setId(jsObject.getString("id"));
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
		
		MedicalClearance medicalClearance = new MedicalClearance();
		medicalClearance.setFile(jsObject.getString("medicalClearance").getBytes());
		child.setMedicalClearance(medicalClearance);
		child.setNote(note);
		

		if (dataService.updateChildToDb(child)) {
			return Response.status(Response.Status.OK).build();
		} else {
			return Response.status(Response.Status.NO_CONTENT).build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Child> readAll() {
		return dataService.readChildrenFromDb();
	}

	@DELETE
	@Path("/{childId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteOne(@PathParam("childId") String childId) {
		Child child = new Child();
		child.setId(childId);
		if (dataService.deleteChildFromDb(child)) {
			return Response.status(Response.Status.OK).build();
		} else {
			return Response.status(Response.Status.NO_CONTENT).build();
		}
	}

}
