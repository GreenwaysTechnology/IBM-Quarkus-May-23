package org.acme.restcommunicator;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

//@RegisterRestClient

@RegisterRestClient(configKey = "hello-api")
@Path("/hello")
public interface HelloRestClientService {
    //methods
    @GET
    Uni<String> sayHello();
}