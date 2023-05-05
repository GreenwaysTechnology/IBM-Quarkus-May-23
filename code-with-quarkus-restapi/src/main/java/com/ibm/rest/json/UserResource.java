package com.ibm.rest.json;


import com.ibm.rest.json.enity.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("users")
public class UserResource {

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(){
        User user = new User(1,"Subramanian",true);
        return user ;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list() {
        return List.of(
                new User(1, "Subramanian",true),
                new User(2, "Murugan",true),
                new User(3, "Karthik",true)
        );
    }
    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User save(User user) {
        System.out.println(user);
        return user;
    }

}
