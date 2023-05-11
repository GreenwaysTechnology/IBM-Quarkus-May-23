package com.ibm.vertx.eventbus.listener;

import io.quarkus.vertx.ConsumeEvent;
import io.vertx.mutiny.core.eventbus.Message;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    //Listener method
    //point to point
    @ConsumeEvent()
    public String consume(String name) {
        return "Hello " + name.toUpperCase();
    }

    //request-reply pattern
    @ConsumeEvent("greeting")
    public void sayGreet(Message<String> msg) {
        //get the Message and process
        System.out.println(msg.body());
        System.out.println(msg.address());
        msg.reply("done");
    }

    //pub sub - many subscribers /consumers
    @ConsumeEvent("notification")
    public void notifyOne(Message<String> msg) {
        //get the Message and process
        System.out.println(msg.body());
        System.out.println(msg.address());
    }

    @ConsumeEvent("notification")
    public void notifyTwo(Message<String> msg) {
        //get the Message and process
        System.out.println(msg.body());
        System.out.println(msg.address());
    }
}
