package org.example;

public class Student extends User {
    public Student(String id, String name) {
        super(id, name);
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }
}