package com.ibm.reactive;

import io.smallrye.mutiny.Uni;

public class ErrorStream {
    public static void main(String[] args) {
        Uni.createFrom()
                .failure(new RuntimeException("Something went wrong"))
                .subscribe().with(err-> System.out.println(err));
    }
}
