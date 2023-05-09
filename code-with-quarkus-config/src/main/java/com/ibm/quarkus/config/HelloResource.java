package com.ibm.quarkus.config;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("greeting")
public class HelloResource {
    @Inject
    GreetingService greetingService;

    @GET
    public String sayHello() {
        return greetingService.getMessage();
    }
}
