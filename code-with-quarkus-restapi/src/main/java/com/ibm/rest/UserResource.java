package com.ibm.rest;

import jakarta.ws.rs.*;

@Path("users")
public class UserResource {

    @GET
    public String list(){
        return "User List";
    }
    //path parameters
    @GET
    @Path("/{id}")
    public String findById(@PathParam("id") Integer id){
        return "User By "+ id;
    }
    //matrix parameter
    @GET
    @Path("/address")
    public String getUserCityAndState(@MatrixParam("city") String city,@MatrixParam("state") String state){
           return "Your city and State" + city + state;
    }

    //Query Parameters
    @GET
    @Path("/mailandphone")
    public String userOrder(@QueryParam("mailId") @DefaultValue("contact@gmail.com") String mailId,@QueryParam("phone") @DefaultValue("0000000000") String phoneNo ) {
        return "Mail Id => " + mailId   + " Phone No =>" + phoneNo;

    }

    @POST
    public String save(){
        return "User Save";
    }
    @PUT
    public String update(){
        return "Update";
    }
    @DELETE
    public String remove(){
        return  "Remove";
    }
}
