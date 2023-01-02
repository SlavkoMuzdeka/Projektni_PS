package project.api;

import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import project.data.GroupDataService;
import project.model.Activity;
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
		}
		return Response.status(404).build();
	}
	
	@GET
	@Path("/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readOne(@PathParam("groupId") Integer groupId) {
		Group group = groupService.readOne(groupId);
		if(group != null) {
			return Response.status(200).entity(group).build();
		}
		return Response.status(404).build();
	}
	
	@POST
	@Path("/{groupId}/child/{childId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertChild(@PathParam("groupId") Integer groupId, @PathParam("childId") Integer childId) {
		if(groupService.insertIntoGroup(groupId, childId, true)) {
			return Response.status(200).build();
		}
		return Response.status(404).build();
	}
	
	@POST
	@Path("/{groupId}/educator/{educatorId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertEducator(@PathParam("groupId") Integer groupId, @PathParam("educatorId") Integer educatorId) {
		if(groupService.insertIntoGroup(groupId, educatorId, false)) {
			return Response.status(200).build();
		}
		return Response.status(404).build();
	}
		
	@DELETE
	@Path("/{groupId}/child/{childId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteChild(@PathParam("groupId") Integer groupId, @PathParam("childId") Integer childId) {
		if(groupService.deleteFromGroup(groupId, childId, true)) {
			return Response.status(200).build();
		}
		return Response.status(404).build();
	}
	
	@DELETE
	@Path("/{groupId}/educator/{educatorId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEducator(@PathParam("groupId") Integer groupId, @PathParam("educatorId") Integer educatorId) {
		if(groupService.deleteFromGroup(groupId, educatorId, false)) {
			return Response.status(200).build();
		}
		return Response.status(404).build();
	}
	
	@POST
	@Path("/{groupName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createGroup(@PathParam("groupName") String groupName) {
		if(groupService.createGroup(groupName)) {
			return Response.status(201).build();
		}
		return Response.status(404).build();
	}
	
	@POST
	@Path("/{groupId}/activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createActivity(String jsonObject, @PathParam("groupId") int groupId) {
		JSONObject jsonObj = new JSONObject(jsonObject);
		
		String name = jsonObj.getString("name");
		String description = jsonObj.getString("description");
		int duration = jsonObj.getInt("duration");
		String date = jsonObj.getString("date");
		
		Activity activity = new Activity();
		activity.setName(name);
		activity.setDescription(description);
		activity.setDate(date);
		activity.setDuration(duration);
		
		if(groupService.addActivityToGroup(activity, groupId)) {
			return Response.status(201).build();
		}
		return Response.status(404).build();
	}
	
	//TODO URADITI BRISANJE AKTIVNOSTI IZ GRUPE
	
}
