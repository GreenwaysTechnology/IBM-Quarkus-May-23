package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("books")
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    public String listBooks(){
        return bookService.createBook();
    }
}
