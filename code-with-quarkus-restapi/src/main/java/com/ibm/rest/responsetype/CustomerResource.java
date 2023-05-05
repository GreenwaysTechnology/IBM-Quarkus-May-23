package com.ibm.rest.responsetype;

import com.ibm.rest.json.enity.Customer;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.annotations.Pos;

import java.net.URI;
import java.util.List;

@Path("customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @GET
    public Response list(){
        return  Response.ok()
                .header("secrete","bar")
                .entity(List.of(new Customer(1,"Subramanian","Murugan")))
                .build();
    }
    @POST
    public Response save(Customer customer){
        return  Response.created(URI.create("/customers")).entity(customer).build();
    }
}
