package com.ibm.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("containerinfo")
public class ContextResource {

    @GET()
    @Path("/urls")
    public String getUriInfo(@Context UriInfo uriInfo) {
        return uriInfo.getAbsolutePath() + " " +uriInfo.getRequestUri();
    }
    @GET()
    @Path("/headers")
    public String getHeaders(@Context HttpHeaders headers) {
        System.out.println(headers.getRequestHeaders());
        return headers.getRequestHeaders().toString();
    }
}
