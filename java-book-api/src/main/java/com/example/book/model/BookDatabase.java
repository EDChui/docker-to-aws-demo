package com.example.book.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A class that act as an actual database.
 */
public class BookDatabase {
    private final Map<Integer, Book> bookMap = new HashMap<>();
    private static int lastId = 0;

    // The database is a singleton object.
    private static final BookDatabase instance = new BookDatabase();
    public  static BookDatabase getInstance() {
        return instance;
    }

    private BookDatabase() {
        addBook(new Book("0262162091", "Types and Programming Languages", "Benjamin C. Pierce"));
        addBook(new Book("0201633612", "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma; Richard Helm; Ralph Johnson; John Vlissides"));
        addBook(new Book("0131103628", "C Programming Language", "Brian W. Kernighan; Dennis M. Ritchie"));
    }

    public Integer addBook(Book book) {
        synchronized (BookDatabase.class) {
            bookMap.put(lastId, book);
            return lastId++;
        }
    }

    public BookWithId getBook(int id) {
        Book book = bookMap.get(id);
        if (book == null)
            return null;
        return new BookWithId(id, bookMap.get(id));
    }

    public List<BookWithId> getAllBooks() {
        return bookMap.entrySet().stream()
                .map(b -> new BookWithId(b.getKey(), b.getValue()))
                .collect(Collectors.toList());
    }

    public void deleteBook(int id) {
        synchronized (BookDatabase.class) {
            bookMap.remove(id);
        }
    }
}
