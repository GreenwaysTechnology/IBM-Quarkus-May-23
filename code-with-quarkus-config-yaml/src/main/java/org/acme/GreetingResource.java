package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "greeting.name", defaultValue = "Name")
    String name;
    @ConfigProperty(name = "greeting.message", defaultValue = "Message")
    String message;
    @ConfigProperty(name = "greeting.city", defaultValue = "City")
    String city;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return message + " " +  name + " from " + city;
    }
}
