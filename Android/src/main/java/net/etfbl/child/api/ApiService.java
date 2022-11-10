package net.etfbl.child.api;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}
