package org.example;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Person[] randomGroupOfPersons = Generator.generateRandomListOfPersons(5, 10);

        for (Person person : randomGroupOfPersons) {
            System.out.println(person.toString());
        }

        LinkedList<Person> drivers = Stream.of(randomGroupOfPersons)
                .filter(Person::getIsDriver)
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toCollection(LinkedList::new));

        TreeSet<Person> passengers = Stream.of(randomGroupOfPersons)
                .filter(Person::getIsPassenger)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))));

        System.out.println("\nDrivers sorted by age:");
        drivers.forEach(System.out::println);

        System.out.println("\nPassengers sorted by name:");
        passengers.forEach(System.out::println);
    }
}
