package org.example;

public class Magazine extends Item {
    private int issueNumber;
    private String publisher;

    public Magazine(String id, String title, int issueNumber, String publisher) {
        super(id, title);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", issueNumber=" + issueNumber +
                '}';
    }
}