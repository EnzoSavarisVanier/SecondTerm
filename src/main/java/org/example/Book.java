package org.example;

public class Book extends Item {
    private String isbn;
    private String author;
    private String genre;

    public Book(String id, String title, String isbn, String author, String genre) {
        super(id, title);
        if (!(isbn.length() == 13)) {
            throw new IllegalArgumentException("Invalid ISBN");
        }
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }
}