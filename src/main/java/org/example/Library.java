package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    public static List<Item> items = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    public List<Item> sortItemsByTitle() {
        return items.stream()
                .sorted(Comparator.comparing(Item::getTitle))
                .collect(Collectors.toList());
    }

    public List<Item> sortItemsById() {
        return items.stream()
                .sorted(Comparator.comparing(Item::getId))
                .collect(Collectors.toList());
    }

    public List<User> sortUsersByName() {
        return users.stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }

    public List<User> sortUsersById() {
        return users.stream()
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());
    }
}