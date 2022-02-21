package dk.vikhub.getrequests;

import entity.Customer;
import facade.CustomerFacade;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/customer")
public class HelloResource {

    CustomerFacade facade = new CustomerFacade();
    @GET
    @Path("/{id}")
    @Produces("text/plain")
    public String hello(@PathParam("id") long id) {
        Customer c = facade.getCustomerById(id);
        return String.format("Firstname: "+c.getFirstname());
    }
}