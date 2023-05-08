package org.acme;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("greeting")
public class GreetingInterfaceResource {

    @Inject
    @Named("hello")
    Greeter hellogreeter;

    @Inject
    @Named("hai")
    Greeter haigreeter;
    @GET
    public String sayHello() {
        return hellogreeter.sayGreet();
    }
    @GET
    @Path("hai")
    public String sayHai() {
        return haigreeter.sayGreet();
    }
}
