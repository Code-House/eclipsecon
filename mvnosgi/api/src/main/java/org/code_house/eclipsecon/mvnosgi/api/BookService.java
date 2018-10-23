package org.code_house.eclipsecon.mvnosgi.api;

import org.code_house.eclipsecon.mvnosgi.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    Optional<Book> find(UUID id);
    UUID addBook(Book book);
    void removeBook(Book book);

    List<Book> getAllBooks();

}
