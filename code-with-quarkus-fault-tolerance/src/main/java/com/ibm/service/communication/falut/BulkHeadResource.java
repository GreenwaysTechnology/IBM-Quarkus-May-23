package com.ibm.service.communication.falut;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.faulttolerance.Fallback;

@Path("/bulk")
public class BulkHeadResource {

    //YOu restrict that this api must be called only number of connections
    //like how many concurrent users can access this api
    //value=5 , concurrently 5 users only allowed to access
    @GET
    @Bulkhead(value = 0)
    @Fallback(fallbackMethod = "fallback")
    public Response dontOverload() {
        System.out.println("Api is called");
        return Response.ok("bulk").build();
    }

    public Response fallback() {
        return Response.ok().entity("fallback bulk").build();
    }
}
