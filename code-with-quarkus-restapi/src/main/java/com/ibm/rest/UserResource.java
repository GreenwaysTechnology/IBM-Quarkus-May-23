package com.ibm.rest;


import jakarta.ws.rs.*;


@Path("users")
public class UserResource {

    @GET
    public String list(){
        return "User List";
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
