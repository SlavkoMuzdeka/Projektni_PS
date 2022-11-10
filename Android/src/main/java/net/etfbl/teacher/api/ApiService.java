package net.etfbl.teacher.api;

import javax.ws.rs.PathParam;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.etfbl.teacher.model.Teacher;

@Path("/teacherLogIn")
public class ApiService {

	TeacherLogInService service;

	public ApiService() {
		service = new TeacherLogInService();
	}

	@GET
	@Path("/{teacher}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response logIn(@PathParam("teacher") String teacher) {
		String username = teacher.split("#")[0];
		String password = teacher.split("#")[1];
		
		if(service.getIsValid(new Teacher("123", username, password))) {
			return Response.status(Response.Status.OK).build(); // 200
		}

		return Response.status(Response.Status.NO_CONTENT).build(); // 204
	}
}
