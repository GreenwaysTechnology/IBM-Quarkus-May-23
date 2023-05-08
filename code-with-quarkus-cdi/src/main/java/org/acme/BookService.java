package org.acme;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BookService {

    @Inject
    NumberGenerator numberGenerator;

    public String createBook() {
        Book book = new Book("Quarkus In Action", "1000", "Subramanian");
        book.setIsbn(numberGenerator.generateISBNNumber());
        return book.toString();
    }
}
