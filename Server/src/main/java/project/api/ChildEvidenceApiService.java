package project.api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import project.data.ChildEvidenceDataSource;
import project.model.Child;

@Path("/childEvidence")
public class ChildEvidenceApiService {

	ChildEvidenceDataSource dataService;

	public ChildEvidenceApiService() {
		dataService = ChildEvidenceDataSource.getInstance();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Child> readAll() {
		return dataService.readAllChildrenFromDB();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response writeAll(String jsonArrayText) {
		JSONArray array = new JSONArray(jsonArrayText);
		ArrayList<Child> children = new ArrayList<Child>();
		for (int i = 0; i < array.length(); i++) {
			JSONObject object = array.getJSONObject(i);
			Child child = new Child();
			child.setId(object.getString("id"));
			child.setIsHere(object.getBoolean("isHere"));
			children.add(child);
		}

		if (dataService.updateChildrenToDB(children)) {
			return Response.status(Response.Status.OK).build();
		}
		return Response.status(Response.Status.NO_CONTENT).build();
	}
}
