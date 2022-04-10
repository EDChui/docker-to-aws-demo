package com.example.book.model;

/**
 * A Book class.
 */
public class Book {
    private final String isbn;
    private final String name;
    private final String author;

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Book(String isbn, String name, String author) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
    }
}
