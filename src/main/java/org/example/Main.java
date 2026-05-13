package org.example;
import java.util.Optional;

public class Main {
    static void main() throws Exception {
        Library library = new Library();
        library.initLibrary("src/main/resources/items.csv", "src/main/resources/users.csv");

        Teacher teacher = new Teacher("123", "Adam");
        Optional<Item> item1 = teacher.searchItemRecursive("Evil Trump");
        Optional<Item> item2 = teacher.searchItemStream("Inception");
        if (item1.isPresent()) {
            teacher.borrowItem(item1.get());
        }
        if (item2.isPresent()) {
            teacher.borrowItem(item2.get());
        }

        Book book = new Book("513", "Man against sky", "9780564127088", "String author", "String genre");
        Library.items.add(book);

        Admin admin = new Admin("321", "John");
        admin.backup("src/main/resources/items.csv", "src/main/resources/users.csv");
        admin.generateReport();
    }
}
