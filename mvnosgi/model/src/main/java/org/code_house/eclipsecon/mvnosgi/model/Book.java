package org.code_house.eclipsecon.mvnosgi.model;

import java.util.Objects;
import java.util.UUID;

public class Book {

    private final UUID id;
    private final String title;
    private final String author;

    public Book(UUID id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
            Objects.equals(title, book.title) &&
            Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author);
    }
}
