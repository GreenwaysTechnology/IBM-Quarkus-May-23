package com.ibm.reactive;

import io.smallrye.mutiny.Multi;

public class MultiStreamProcessing {
    public static void main(String[] args) {
        Multi.createFrom().items(1,2,3,4,5,6,7,8,9,10)
                .onItem().transform(item->item*2)
                .onItem().transform(item->item+1)
                .select().first(5)
                .subscribe().with(item-> System.out.println(item));
    }
}
