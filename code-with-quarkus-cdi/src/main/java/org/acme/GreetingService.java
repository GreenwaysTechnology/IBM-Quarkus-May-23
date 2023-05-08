package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
    //api
    public String sayHello(){
        return "Hello!!!";
    }
}
