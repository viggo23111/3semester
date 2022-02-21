package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.EmployeeDTO;
import entities.Employee;
import facades.EmployeeFacade;
import utils.EMF_Creator;
import facades.FacadeExample;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/emp")
public class EmployeeRest {

    EmployeeFacade facade = new EmployeeFacade();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEmployeeById(@PathParam("id") long id) {
        EmployeeDTO e = facade.getEmployeeById(id);
        return Response
                .ok()
                .entity(gson.toJson(e))
                .build();
    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllEmployees() {
        List<EmployeeDTO> c = facade.getAllEmployees();
        return Response
                .ok()
                .entity(gson.toJson(c))
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployee(String jsonContext) {
        Employee c = gson.fromJson(jsonContext, Employee.class);
        Employee addEmployee = new Employee(c.getName(), c.getAddress(),c.getSalary());
        return Response
                .ok("SUCCESS")
                .cookie(new NewCookie("test", c.getName()))
                .entity(gson.toJson(facade.addEmployee(addEmployee)))
                .build();
    }

}
