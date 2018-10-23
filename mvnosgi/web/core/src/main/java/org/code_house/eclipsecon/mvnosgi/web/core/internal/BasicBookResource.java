package org.code_house.eclipsecon.mvnosgi.web.core.internal;

import org.code_house.eclipsecon.mvnosgi.api.BookService;
import org.code_house.eclipsecon.mvnosgi.dto.BookDTO;
import org.code_house.eclipsecon.mvnosgi.web.api.BookResource;
import org.code_house.eclipsecon.mvnosgi.web.core.internal.convert.ToDto;

import java.util.UUID;

public class BasicBookResource implements BookResource {

    private final BookService service;
    private final UUID id;

    public BasicBookResource(BookService service, UUID id) {
        this.service = service;
        this.id = id;
    }

    @Override
    public BookDTO get() {
        return service.find(id)
            .map(new ToDto())
            .orElse(null);
    }

    @Override
    public boolean delete() {
        return service.find(id).map(book -> {
            service.removeBook(book);
            return true;
        }).orElse(false);
    }
}
