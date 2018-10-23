package org.code_house.eclipsecon.mvnosgi.web.core.internal.convert;

import org.code_house.eclipsecon.mvnosgi.model.Book;
import org.code_house.eclipsecon.mvnosgi.dto.BookDTO;

import java.util.function.Function;

public class ToDto implements Function<Book, BookDTO> {

    @Override
    public BookDTO apply(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.id = book.getId().toString();
        bookDTO.title = book.getTitle();
        bookDTO.author = book.getAuthor();
        return bookDTO;
    }

}
