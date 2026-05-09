package org.example;

public class Teacher extends User {
    public Teacher(String id, String name) {
        super(id, name);
    }

    @Override
    public int getBorrowLimit() {
        return 10;
    }
}