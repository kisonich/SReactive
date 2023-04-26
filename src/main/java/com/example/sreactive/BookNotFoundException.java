package com.example.sreactive;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(long id) {
        super("Book not found with ID: " + id);

    }
}
