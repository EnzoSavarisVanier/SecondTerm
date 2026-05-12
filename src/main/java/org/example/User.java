package org.example;
import lombok.*;
import java.util.*;
import static org.example.Library.items;

@Getter
public abstract class User {
    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public abstract int getBorrowLimit();

    public void borrowItem(Item item) throws Exception {
        if (borrowedItems.size() >= getBorrowLimit()) {
            throw new Exception("Borrow limit reached");
        }
        if (item.getStatus() != Item.Status.IN_STORE) {
            throw new Exception("Item is unavailable");
        }
        if (this instanceof Student && !(item instanceof Book)) {
            throw new Exception("Students can only borrow books");
        }
        borrowedItems.add(item);
        item.setStatus(Item.Status.BORROWED);
    }

    public void returnItem(Item item) {
        borrowedItems.remove(item);
        item.setStatus(Item.Status.IN_STORE);
    }

    public Optional<Item> searchItemStream(String title) {
        return items.stream()
                .filter(item -> Objects.equals(item.getTitle(), title))
                .findFirst();
    }

    public Optional<Item> searchItemRecursive(String title) {
        return searchItemRecursiveHelper(title, 0);
    }

    private Optional<Item> searchItemRecursiveHelper(String title, int index) {
        if (index >= items.size()) {
            return Optional.empty();
        }

        if (items.get(index).getTitle().equals(title)) {
            return Optional.ofNullable(items.get(index));
        }

        return searchItemRecursiveHelper(title, index + 1);
    }
}
