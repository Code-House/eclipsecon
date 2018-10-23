package org.code_house.eclipsecon.mvnosgi.core.internal;

import org.code_house.eclipsecon.mvnosgi.dao.api.BookDAO;
import org.code_house.eclipsecon.mvnosgi.model.Book;
import org.code_house.eclipsecon.mvnosgi.api.BookService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PersistentBookService implements BookService {

    private BookDAO bookDAO;

    @Override
    public Optional<Book> find(UUID id) {
        return Optional.ofNullable(bookDAO.find(id));
    }

    @Override
    public UUID addBook(Book book) {
        return bookDAO.store(book);
    }

    @Override
    public void removeBook(Book book) {
        bookDAO.remove(book.getId());
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.all();
    }

    @Reference
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
}
