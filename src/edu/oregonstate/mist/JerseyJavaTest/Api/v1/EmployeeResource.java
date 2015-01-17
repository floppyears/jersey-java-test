package edu.oregonstate.mist.JerseyJavaTest.Api.v1;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import edu.oregonstate.mist.JerseyJavaTest.*;

@Path("api/v1/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

	@GET
	public String getAll() {
		return "would get all employees\n";
	}

	@GET
	@Path("{id: \\d+}")
	public JsonObject getById(@PathParam("id") Integer id) {
		Employee employee = Application.database.getEmployeeById(id);

		if (employee == null) {
			throw new WebApplicationException(404);
		} else {
			// serialize employee as json
			return Json.createObjectBuilder()
					.add("osuId",          employee.getOsuId())
					.add("firstName",      employee.getFirstName())
					.add("middleInitial",  employee.getMiddleInitial())
					.add("lastName",       employee.getLastName())
					.add("onidLoginId",    employee.getOnidLoginId())
					.add("emailAddress",   employee.getEmailAddress())
					.add("employeeStatus", employee.getEmployeeStatus())
					.build();
		}
	}

	@POST
	@Path("{id: \\d+}")
	public String set(String requestBody) {
		return "would create employee from json: " + requestBody + "\n";
	}
}
