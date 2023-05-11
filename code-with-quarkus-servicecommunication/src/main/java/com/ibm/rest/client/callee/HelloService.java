package com.ibm.rest.client.callee;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {

    public String sayHello(){
        return "Hello callee!!!!";

    }
}
