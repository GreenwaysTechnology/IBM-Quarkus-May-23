package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("hello")
public class HelloImplementation implements Greeter{
    @Override
    public String sayGreet() {
        return "Hello";
    }
}
