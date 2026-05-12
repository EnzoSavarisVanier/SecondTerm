package org.example;

public class Book extends Item {
    private String isbn;
    private String author;
    private String genre;

    public Book(String id, String title, String isbn, String author, String genre) {
        super(id, title);
        if (!(isbn.matches("\\d{13}"))) {
            throw new IllegalArgumentException("Invalid ISBN");
        }
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}