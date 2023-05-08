package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
    //GreetingService greetingService = new GreetingService();
    //field injecton
   // @Inject
   // private GreetingService greetingService;

//    private  GreetingService greetingService;
    GreetingService greetingService;
    public GreetingResource() {
    }

    @Inject
    public GreetingResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    //setter injection
    //
//     @Inject
//    public void setGreetingService(GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingService.sayHello();
    }
}
