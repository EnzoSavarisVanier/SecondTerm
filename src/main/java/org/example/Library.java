package org.example;
import java.io.*;
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

    public void initLibrary(String itemsPath, String usersPath) {
        File itemsFile = new File(itemsPath);
        File usersFile = new File(usersPath);

        try (Scanner scanner = new Scanner(itemsFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] row = line.split(",");
                switch (row[0].trim()) {
                    case "BOOK"     -> items.add(new Book(row[1].trim(), row[2].trim(), row[3].trim(), row[4].trim(), row[5].trim()));
                    case "DVD"      -> items.add(new DVD(row[1].trim(), row[2].trim(), row[3].trim(), Integer.parseInt(row[4].trim())));
                    case "MAGAZINE" -> items.add(new Magazine(row[1].trim(), row[2].trim(), Integer.parseInt(row[3].trim()), row[4].trim()));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Scanner scanner = new Scanner(usersFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] row = line.split(",");
                switch (row[0].trim()) {
                    case "STUDENT" -> users.add(new Student(row[1].trim(), row[2].trim()));
                    case "TEACHER" -> users.add(new Teacher(row[1].trim(), row[2].trim()));
                    case "ADMIN"   -> users.add(new Admin(row[1].trim(), row[2].trim()));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}