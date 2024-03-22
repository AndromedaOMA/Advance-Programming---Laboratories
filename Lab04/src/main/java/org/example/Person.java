package org.example;

public class Person {
    private String name;
    private int age;
    private String destination;

//    public Person(String name, int age, String destination) {
//        this.setName(name);
//        this.setAge(age);
//        this.setDestination(destination);
//    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isDriver() {
        return this instanceof Driver;
    }
    public boolean isPassenger() {
        return this instanceof Passenger;
    }

    @Override
    public String toString() {
        if (this instanceof Driver) {
            return this.getName() + " is a driver and is " + this.getAge() + " years old and is going to " + this.getDestination() + "!";
        } else {
            return this.getName() + " is a passenger and is " + this.getAge() + " years old and is going to " + this.getDestination() + "!";
        }
    }
}
