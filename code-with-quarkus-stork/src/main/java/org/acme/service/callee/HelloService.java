package org.acme.service.callee;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class HelloService {

    public Uni<String> sayHello(){
        return Uni.createFrom().item("Hello Strok");
    }

}