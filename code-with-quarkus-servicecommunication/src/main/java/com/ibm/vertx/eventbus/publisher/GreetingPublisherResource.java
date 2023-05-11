package com.ibm.vertx.eventbus.publisher;

import com.ibm.vertx.eventbus.listener.GreetingService;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;
import io.vertx.mutiny.core.eventbus.Message;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("eventbus")
public class GreetingPublisherResource {
    @Inject
    EventBus eventBus;

    @GET
    @Path("/requestreply")
    public Uni<String> hello() {
        //Request-Reply pattern - with ack
        return eventBus.<String>request(GreetingService.class.getName().toString(), "Subramanian")
                .onItem().transform(Message::body);
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{name}")
    public String greet(@PathParam("name") String name) {
        //Request-Reply (request and forget) pattern : point to point
        EventBus bus = eventBus.requestAndForget("greeting", name);
        return "Processed";
    }
    //pubsub pattern publishes messages to many subscribers

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/push/{msg}")
    public String notifyPush(@PathParam("msg") String msg) {
        //pub - sub pattern
        eventBus.publish("notification", msg).toString();
        return "Published";
    }

}
