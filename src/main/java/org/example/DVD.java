package org.example;

public class DVD extends Item {
    private String director;
    private int duration;

    public DVD(String id, String title, String director, int duration) {
        super(id, title);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", duration=" + duration +
                '}';
    }
}
