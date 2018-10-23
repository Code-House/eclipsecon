package org.code_house.eclipsecon.mvnosgi.web.core.internal.convert;

import org.code_house.eclipsecon.mvnosgi.model.Book;
import org.code_house.eclipsecon.mvnosgi.dto.BookDTO;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class FromDto implements Function<BookDTO, Book> {

    @Override
    public Book apply(BookDTO dto) {
        UUID id = Optional.ofNullable(dto.id)
            .map(UUID::fromString)
            .orElse(null);
        return new Book(id, dto.title, dto.author);
    }

}
