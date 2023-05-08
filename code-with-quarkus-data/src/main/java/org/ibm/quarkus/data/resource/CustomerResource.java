package org.ibm.quarkus.data.resource;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ibm.quarkus.data.entity.Customer;

import java.util.List;

@Path("customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @GET
    public Uni<List<Customer>> get() {
        return Customer.listAll();
    }


    //Get Customer byId
    @GET
    @Path("/byid/{id}")
    public Uni<Customer> findById(Long id) {
        return Customer.findById(id);
    }

    //create /save : Transaction must be enabled when we do add or delete,update
    //Incase of reactive transaction is enabled via code, in non reactive env
    //we use @Transactional annoation
    @POST
    public Uni<Response> create(Customer customer) {
        //handle error
        if (customer == null || customer.name == null) {
            //throw exception
            throw new WebApplicationException("Customer Not found", 422);
        }
        return Panache
                .withTransaction(customer::persist)
                .replaceWith(Response.ok(customer)
                        .status(Response.Status.CREATED)
                        .build());
    }

    //delete a row
    @DELETE
    @Path("/byid/{id}")
    public Uni<Response> delete(Long id) {
        return Panache
                .withTransaction(() -> Customer.deleteById(id))
                .map(deleted -> deleted
                        ? Response.ok().status(Response.Status.NO_CONTENT).build()
                        : Response.ok().status(Response.Status.NOT_FOUND).build());
    }

    //Update

    @PUT
    @Path("/byid/{id}")
    public Uni<Response> update(Long id, Customer customer) {
        if (customer == null || customer.name == null) {
            throw new WebApplicationException("Customer Not Found", 422);
        }
        //Update
        return Panache.withTransaction(() -> Customer.<Customer>findById(id)
                .onItem()
                .ifNotNull()
                .invoke(entity -> {
                    entity.city = customer.city;
                    entity.name= customer.name;
                }) //update logic
                .onItem().ifNotNull().transform(entity -> Response.ok(entity).build())
                .onItem().ifNull().continueWith(Response.ok().status(Response.Status.NOT_FOUND)::build));

    }
}