package project.api;

import javax.ws.rs.PathParam;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
