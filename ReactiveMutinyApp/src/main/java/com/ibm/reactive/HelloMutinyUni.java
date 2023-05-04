package com.ibm.reactive;

import io.smallrye.mutiny.Uni;

public class HelloMutinyUni {
    public static void main(String[] args) {
        //Create Uni Publisher
        Uni.createFrom()
                .item("Hello Mutiny") //publisher
                .subscribe()//subscriber
                .with(item->System.out.println(item));


    }
}
