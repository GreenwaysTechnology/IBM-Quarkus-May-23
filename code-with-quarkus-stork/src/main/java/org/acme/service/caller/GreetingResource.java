package org.acme.service.caller;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.ext.web.client.HttpResponse;
import io.vertx.mutiny.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.mutiny.core.Vertx;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.restcommunicator.HelloRestClientService;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@Path("/greet")
public class GreetingResource {

    @Inject
    @RestClient
    HelloRestClientService helloRestClientService;

    //Grab Vertx Runtime instance
    @Inject
    Vertx vertx;
    WebClient webClient;

    //init
    @PostConstruct
    public void init() {
        //create webclient instance through which you can communicate
        webClient = WebClient.create(vertx, new WebClientOptions()
                .setDefaultHost("localhost")
                .setDefaultPort(8080));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        return helloRestClientService.sayHello();
    }

    //Access the HaiResource via Vertx Client.
    @GET
    @Path("/vertx")
    public Uni<String> sayHai() {
        return webClient.get("/hai").send().onItem().transform(HttpResponse::bodyAsString);
    }


}
