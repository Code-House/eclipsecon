package org.code_house.eclipsecon.mvnosgi.dao.core.internal;

import org.code_house.eclipsecon.mvnosgi.dao.api.BookDAO;
import org.code_house.eclipsecon.mvnosgi.model.Book;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class MemoryBookDAO implements BookDAO {

    private final Map<UUID, Book> bookMap = new HashMap<>();

    @Override
    public List<Book> all() {
        return new ArrayList<>(bookMap.values());
    }

    @Override
    public Book find(UUID id) {
        return bookMap.get(id);
    }

    @Override
    public UUID store(Book book) {
        if (book.getId() != null) {
            throw new IllegalArgumentException("Book can not have assigned id");
        }

        Book entity = new Book(UUID.randomUUID(), book.getTitle(), book.getAuthor());
        bookMap.put(entity.getId(), entity);
        return entity.getId();
    }

    @Override
    public void remove(UUID bookId) {
        bookMap.remove(bookId);
    }

}
