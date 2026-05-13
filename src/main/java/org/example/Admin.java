package org.example;
import java.io.*;
import static org.example.Library.items;
import static org.example.Library.users;

public class Admin extends User implements Reportable {
    public Admin(String id, String name) {
        super(id, name);
    }

    @Override
    public int getBorrowLimit() {
        return 0;
    }


    @Override
    public void generateReport() {
        System.out.println("BORROWED ITEMS");
        items.stream()
                .filter(item -> item.getStatus() == Item.Status.BORROWED)
                .forEach(System.out::println);

        System.out.println("IN STORE ITEMS");
        items.stream()
                .filter(item -> item.getStatus() == Item.Status.IN_STORE)
                .forEach(System.out::println);

        System.out.println("LOST ITEMS");
        items.stream()
                .filter(item -> item.getStatus() == Item.Status.LOST)
                .forEach(System.out::println);
    }

    public void backup(String itemsPath, String usersPath) {
        File itemsFile = new File(itemsPath);
        File usersFile = new File(usersPath);

        try {
            FileWriter fw = new FileWriter(itemsFile, false);
            for (Item item : items) {
                String line = switch (item) {
                    case Book b     -> String.join(",", "BOOK", b.getId(), b.getTitle(), b.getIsbn(), b.getAuthor(), b.getGenre());
                    case DVD d      -> String.join(",", "DVD", d.getId(), d.getTitle(), d.getDirector(), String.valueOf(d.getDuration()));
                    case Magazine m -> String.join(",", "MAGAZINE", m.getId(), m.getTitle(), String.valueOf(m.getIssueNumber()), m.getPublisher());
                    default         -> "";
                };
                fw.write(line + "\n");
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter fw = new FileWriter(usersFile, false);
            for (User user : users) {
                String line = String.join(",", user.getClass().getSimpleName().toUpperCase(), user.getId(), user.getName());
                fw.write(line + "\n");
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
