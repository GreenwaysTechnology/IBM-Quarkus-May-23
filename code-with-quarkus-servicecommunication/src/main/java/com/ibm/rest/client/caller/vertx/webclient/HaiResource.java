package com.ibm.rest.client.caller.vertx.webclient;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("caller/vertxwebclient")
public class HaiResource {

    @Inject
    HaiService haiService;

    @GET
    public Uni<String> sayHai() {
        return haiService.sayHai();
    }
}
