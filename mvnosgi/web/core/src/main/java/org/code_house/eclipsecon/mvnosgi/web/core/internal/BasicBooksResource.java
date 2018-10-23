package org.code_house.eclipsecon.mvnosgi.web.core.internal;

import org.code_house.eclipsecon.mvnosgi.api.BookService;
import org.code_house.eclipsecon.mvnosgi.dto.BookDTO;
import org.code_house.eclipsecon.mvnosgi.web.api.BookResource;
import org.code_house.eclipsecon.mvnosgi.web.api.BooksResource;
import org.code_house.eclipsecon.mvnosgi.web.core.internal.convert.FromDto;
import org.code_house.eclipsecon.mvnosgi.web.core.internal.convert.ToDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BasicBooksResource implements BooksResource {

    private final BookService service;

    public BasicBooksResource(BookService service) {
        this.service = service;
    }

    @Override
    public List<BookDTO> get() {
        return service.getAllBooks().stream()
            .map(new ToDto())
            .collect(Collectors.toList());
    }

    @Override
    public BookResource book(UUID book) {
        return new BasicBookResource(service, book);
    }

    @Override
    public BookResource create(BookDTO book) {
        UUID id = service.addBook(new FromDto().apply(book));
        return book(id);
    }
}
