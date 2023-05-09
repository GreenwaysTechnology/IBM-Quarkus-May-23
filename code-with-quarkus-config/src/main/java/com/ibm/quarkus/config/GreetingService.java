package com.ibm.quarkus.config;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Optional;

@ApplicationScoped
public class GreetingService {

    //defaultValue via defaultvalue attribute
    @ConfigProperty(name = "greeting.message", defaultValue = "Hello default Value")
    String message;

    //default value can be supplied without defaultValue attribute
    @ConfigProperty(name = "greeting.name")
    Optional<String> name;

    //read config values without @ConfigProperty annotation: read via code
    //String city = ConfigProvider.getConfig().getValue("greeting.city",String.class);
    String city = ConfigProvider.getConfig().getOptionalValue("greeting.city", String.class).orElse("Delhi");

    public String getMessage() {
        return message + "\t" + name.orElse("Bar") + " City " + city;
    }
}
