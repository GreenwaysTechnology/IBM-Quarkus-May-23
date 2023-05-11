package com.ibm.rest.client.caller;

import com.ibm.rest.client.restcommunicator.HelloRestClientService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class GreetingService {
    @Inject
    @RestClient
    HelloRestClientService helloRestClientService;

    public String sayGreet(){
        return helloRestClientService.sayHello();
    }
}
