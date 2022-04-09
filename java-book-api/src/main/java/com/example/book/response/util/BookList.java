package com.example.book.response.util;

import com.example.book.model.Book;

import java.util.List;

public record BookList(List<? extends Book> books) {
}
