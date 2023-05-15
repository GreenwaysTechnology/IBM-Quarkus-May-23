package org.acme;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

@ApplicationScoped
public class HelloService {

    @Inject
    Logger logger;

    public Uni<String> sayHello(){
        logger.warn("Hello Service method");
        return Uni.createFrom().item("Hello");
    }
}
