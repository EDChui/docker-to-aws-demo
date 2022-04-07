package com.example.book.controller;

import com.example.book.model.BookDatabase;
import com.example.book.model.*;
import com.example.book.response.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BookDatabaseController {
    @GetMapping("/")
    public Message root() {
        return new Message("App is running.");
    }

    @PostMapping("/books")
    public Id addBook(@RequestBody Book book) {
        return new Id(BookDatabase.getInstance().addBook(book));
    }

    @GetMapping("/books")
    public List<? extends Book> getAllBooks() {
        return BookDatabase.getInstance().getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id) {
        Book book = BookDatabase.getInstance().getBook(id);
        if (book != null) {
            return book;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found.");
        }
    }

    @DeleteMapping("/books/{id}")
    public Message deleteBook(@PathVariable int id) {
        BookDatabase.getInstance().deleteBook(id);
        return new Message("Success.");
    }
}
