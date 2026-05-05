package org.example;
import lombok.*;

@Getter
@Setter
public abstract class Item {
    protected String id;
    protected String title;
    protected Status status;

    public Item(String id, String title) {
        this.id = id;
        this.title = title;
        this.status = Status.IN_STORE;
    }

    public enum Status {
        IN_STORE,
        BORROWED,
        LOST
    }
}
