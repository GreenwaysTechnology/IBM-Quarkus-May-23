package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("greet")
public class HelloResource {

    @ConfigProperty(name = "greeting.message", defaultValue = "message")
    String message;

    @GET
    public String sayGreet() {
        return message;
    }
}
