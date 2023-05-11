package com.ibm.rest.client.caller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

//Caller service
@Path("greeting/caller")
public class GreeterResource {


    @Inject
    GreetingService greetingService;

    @GET
    public String sayGreet(){
        return greetingService.sayGreet();

    }
}
