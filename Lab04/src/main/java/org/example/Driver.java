package org.example;

public class Driver extends Person{
    Passenger passenger;

    public Driver(String name, int age, String destination) {
        this.setName(name);
        this.setAge(age);
        this.setDestination(destination);
    }
}
