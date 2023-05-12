package org.acme.service.registry.beans;

import io.quarkus.runtime.StartupEvent;
import io.vertx.ext.consul.ConsulClientOptions;
import io.vertx.ext.consul.ServiceOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.consul.ConsulClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@ApplicationScoped
public class Registration {

    @ConfigProperty(name = "consul.host")
    String host;
    @ConfigProperty(name = "consul.port")
    int port;

    @ConfigProperty(name = "hello-service-port", defaultValue = "8080")
    int servicePort;

    public void init(@Observes StartupEvent ev, Vertx vertx) {

        //consul server registration
        ConsulClient client = ConsulClient.create(vertx, new ConsulClientOptions()
                .setHost(host).setPort(port));

        //service bean registration
        client.registerServiceAndAwait(
                new ServiceOptions().setPort(servicePort).setAddress("localhost")
                        .setName("hello-service").setId("hello"));

        //more service bean registration

    }
}
