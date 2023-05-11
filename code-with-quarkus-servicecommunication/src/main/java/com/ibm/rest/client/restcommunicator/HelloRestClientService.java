package com.ibm.rest.client.restcommunicator;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("callee/hello")
//@RegisterRestClient
@RegisterRestClient(configKey = "hello-api")
public interface HelloRestClientService {
    //methods
    @GET
    String sayHello();
}
