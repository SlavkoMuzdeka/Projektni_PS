package net.etfbl.child.api;

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

import net.etfbl.child.model.Child;
import net.etfbl.child.api.ChildEvidenceService;

@Path("/childEvidence")
public class ApiService {

	ChildEvidenceService service;

	public ApiService() {
		service = new ChildEvidenceService();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Child> getAll() {
		return service.getAllChilds();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response edit(String jsonArrayText) {
		JSONArray array = new JSONArray(jsonArrayText);
		ArrayList<Child> childs = new ArrayList<Child>();
		for (int i = 0; i < array.length(); i++) {
			JSONObject object = array.getJSONObject(i);
			childs.add(new Child(object.getInt("id"), object.getString("name"), object.getString("parentName"),
					object.getString("surname"), object.getBoolean("isHere")));
		}
		
		if (service.setAllChilds(childs)) {
			return Response.status(Response.Status.OK).build();
		}
		return Response.status(Response.Status.NO_CONTENT).build();
	}
}
