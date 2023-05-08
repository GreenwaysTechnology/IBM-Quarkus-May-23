package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("hai")
public class HaiImplementation implements Greeter {
    @Override
    public String sayGreet() {
        return "Hai";
    }
}
