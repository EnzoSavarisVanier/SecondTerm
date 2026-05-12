package org.example;

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
        Library.items.stream()
                .filter(item -> item.getStatus() == Item.Status.BORROWED)
                .forEach(System.out::println);

        Library.items.stream()
                .filter(item -> item.getStatus() == Item.Status.IN_STORE)
                .forEach(System.out::println);

        Library.items.stream()
                .filter(item -> item.getStatus() == Item.Status.LOST)
                .forEach(System.out::println);
    }
}
