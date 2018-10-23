package org.code_house.eclipsecon.mvnosgi.dao.api;

import org.code_house.eclipsecon.mvnosgi.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookDAO {

    List<Book> all();

    Book find(UUID id);

    UUID store(Book book);

    void remove(UUID bookId);

}
