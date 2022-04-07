package com.example.book.response.util;

public record Message(String message) {
    public String getMessage() {
        return message;
    }
}
