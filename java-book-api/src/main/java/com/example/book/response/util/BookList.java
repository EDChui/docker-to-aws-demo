package com.example.book.response.util;

import com.example.book.model.Book;

import java.util.List;

public final class BookList {
    private List<? extends Book> books;

    public List<? extends Book> getBooks() {
        return books;
    }

    public BookList(List<? extends Book> books) {
        this.books = books;
    }
}
