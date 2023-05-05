package com.ibm.rest.reactive;

import com.ibm.rest.json.enity.Book;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.List;

@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookReactiveResource {

    //blocking apis : if method returns string,void,collection,object
    //Book
    @GET
    @Path("/nonreactive")
    public List<Book> listBooks() {
        System.out.println("Current Thread Non Reactive - listBooks " + Thread.currentThread().getName());
        return List.of(new Book("1222", "Quarkus in Action", "Subramanian"));
    }

    //Non blocking operations: if any api returns uni or multi that is called non blocking operations
    @GET
    @Path("/reactive")
    public Uni<List<Book>> getBooks() {
        System.out.println("Current Thread - Reactive -  getBooks " + Thread.currentThread().getName());
        List books = List.of(new Book("1222", "Quarkus in Action", "Subramanian"));
        return Uni.createFrom().item(books); //return uni
    }

    //what if , you block event loop thread by writing bad code.
    @GET
    @Path("/reactive/blocking")
    public Uni<List<Book>> getBooksByBlocking() throws InterruptedException {
        //Thread
        Thread.sleep(10_000);
        List books = List.of(new Book("1222", "Quarkus in Action", "Subramanian"));
        return Uni.createFrom().item(books); //return uni
    }

    //what if i want to write blocking code inside non blocking.

    @GET
    @Path("/dontblockeventloop")
    @Blocking //safely delegate the work to worker thread...
    public Uni<List<Book>> blockBooks() throws InterruptedException {
        System.out.println("Current Thread - getBooks " + Thread.currentThread().getName());
        //Thread.sleep(2000);
        Thread.sleep(10_000);
        List books = List.of(new Book("1222","Quarkus in Action","Subramanian"));
        return Uni.createFrom().item(books);
    }

    @GET
    @Path("/nonblockingdelay")
    public Uni delayBooks()  {
        System.out.println("Current Thread - getBooks " + Thread.currentThread().getName());
        List books = List.of(new Book("1222", "Quarkus in Action", "Subramanian"));
        return Uni.createFrom().item(books).onItem().delayIt().by(Duration.ofSeconds(2));
    }
}
