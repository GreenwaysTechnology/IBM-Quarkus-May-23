package com.ibm.rest.client.callee;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("callee/hello")
public class HelloResource {

    @Inject
    HelloService helloService;

    @GET
    public String sayHello(){
        return helloService.sayHello();
    }
}
