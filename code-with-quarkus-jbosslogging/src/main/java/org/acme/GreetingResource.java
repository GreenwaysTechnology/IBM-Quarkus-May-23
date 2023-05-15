package org.acme;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
//import org.jboss.logging.Logger;

@Path("/hello")
public class GreetingResource {
    //logger declartion
//    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @Inject
    HelloService helloService;

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public Uni<String> hello() {
//        Log.info("Hello method is called");
//        return Uni.createFrom().item(helloService.sayHello().onItem().toString());
//
//    }
    @GET
    public String hello(){
        Log.info("Hello method is called");
        return "Hello from RESTEasy Reactive";
    }
}
