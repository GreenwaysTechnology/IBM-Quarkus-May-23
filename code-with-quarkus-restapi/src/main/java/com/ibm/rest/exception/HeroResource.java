package com.ibm.rest.exception;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("heros")
public class HeroResource {
    @GET
    @Path("/hero/{name}")
    public Response getHero(@PathParam("name") String name) {
        if (name.equals("myhero")) {
            return Response.ok().entity("Hero " + name).build();
        }
        throw new WebApplicationException();
    }
}
