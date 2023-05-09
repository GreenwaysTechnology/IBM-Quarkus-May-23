package org.acme;

import io.quarkus.cache.CacheInvalidateAll;
import io.quarkus.cache.CacheResult;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Date;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @CacheResult(cacheName = "message")
    public String hello() {
        System.out.println("Method called " + new Date());
        return "Hello from RESTEasy Reactive";
    }
    //remove cache through code

    @POST
    @CacheInvalidateAll(cacheName = "message")
    public void invalidateAll(){

    }
}
