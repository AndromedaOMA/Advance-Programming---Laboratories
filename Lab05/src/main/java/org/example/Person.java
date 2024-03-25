package org.example;

public record Person(String name, String id, String department) {
    public Person(String name, String id, String department){
        this.name=name;
        this.id=id;
        this.department=department;
    }
}
