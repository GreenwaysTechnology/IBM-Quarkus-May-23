package com.ibm.rest.client.callee.vertx.webclient;


import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("callee/hai")
public class HaiVertxWebClientCallee {

    @GET
    public Uni<String> sayHai() {
        return Uni.createFrom().item("Hello Vertx WebClient!!!");
    }
}
