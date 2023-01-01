package project.api;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import project.data.GroupDataService;
import project.model.Group;

@Path("/groups")
public class GroupApiService {
	
	public GroupDataService groupService;
	
	public GroupApiService() {
		groupService = GroupDataService.getIstance();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response readAll() {
		ArrayList<Group> groups = groupService.readAll();
		if(groups != null) {
			return Response.status(200).entity(groups).build();
		}else {
			return Response.status(500).build();
		}
	}
	
	@GET
	@Path("/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readOne(@PathParam("groupId") Integer groupId) {
		Group group = groupService.readOne(groupId);
		if(group != null) {
			return Response.status(200).entity(group).build();
		}else {
			return Response.status(500).build();
		}
	}
	
	
	
}
