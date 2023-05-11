package com.ibm.rest.client.caller.vertx.webclient;

import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.client.HttpResponse;
import io.vertx.mutiny.ext.web.client.WebClient;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class HaiService {

    @Inject
    Vertx vertx;
    WebClient webClient;

    //bean life cycle
    @PostConstruct
    public void init(){
        //create webclient instance through which you can communicate
        webClient = WebClient.create(vertx, new WebClientOptions()
                .setDefaultHost("localhost")
                .setDefaultPort(8080));
    }
    public Uni<String> sayHai(){
        //calling remote api directly
        //url http://localhost:8080/callee/hai
        return webClient.get("/callee/hai").send().onItem().transform(HttpResponse::bodyAsString);
    }
}
