package com.example.book.model;

/**
 * A final class BookWithId.
 */
public final class BookWithId extends Book {
    private final int id;

    public int getId() {
        return id;
    }

    public BookWithId(int id, String isbn, String name, String author) {
        super(isbn, name, author);
        this.id = id;
    }

    public BookWithId(int id, Book book) {
        super(book.getIsbn(), book.getName(), book.getAuthor());
        this.id = id;
    }
}
