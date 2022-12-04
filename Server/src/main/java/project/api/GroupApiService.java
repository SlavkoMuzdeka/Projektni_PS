package project.api;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import project.data.GroupDataSource;
import project.model.Group;

@Path("/groups")
public class GroupApiService {

	GroupDataSource groupService;

	public GroupApiService() {
		groupService = GroupDataSource.getInstance();
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGroups(){
		ArrayList<Group> groups = groupService.getGroups();
		return Response.status(200).entity(groups).build();
	}

}
