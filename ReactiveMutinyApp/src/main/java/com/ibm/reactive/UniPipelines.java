package com.ibm.reactive;


import io.smallrye.mutiny.Uni;

import java.time.Duration;

/**
 * pipeline is nothing creating stream send data over stream while sending we can setup
 *  processing boundry
 *  pipe line apis : transform,filter,
 */
public class UniPipelines {
    public static void main(String[] args) {
        System.out.println("start");
        Uni.createFrom().item("hello")
                .onItem().transform(item->item.toUpperCase())
                .onItem().transform(item->item + "Subramanian")
                .onItem().delayIt().by(Duration.ofMillis(5000))
                .subscribe().with(res-> System.out.println(res));
        System.out.println("end");
    }
}
