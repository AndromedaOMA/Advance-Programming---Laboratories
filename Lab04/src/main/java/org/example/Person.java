package org.example;

public class Person {
    private boolean isPassenger;
    private boolean isDriver;
    private String name;
    private String destination;
    private int age;

    public Person(String var1, int var2, boolean var3, boolean var4) {
        this.name = var1;
        this.age = var2;
        this.isPassenger = var3;
        this.isDriver = var4;
    }

    public boolean getIsPassenger() {
        return this.isPassenger;
    }

    public void setPassenger(boolean var1) {
        this.isPassenger = var1;
    }

    public boolean getIsDriver() {
        return this.isDriver;
    }

    public void setDriver(boolean var1) {
        this.isDriver = var1;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String var1) {
        this.name = var1;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int var1) {
        this.age = var1;
    }

    @Override
    public String toString() {
        String var10000;
        if (this.getIsDriver()) {
            var10000 = this.getName();
            return var10000 + " is a driver and is " + this.getAge() + " years old!";
        } else {
            var10000 = this.getName();
            return var10000 + " is a passenger and is " + this.getAge() + " years old!";
        }
    }
}
