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
                .filter(Person::isDriver)
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("\nDrivers sorted by age:");
        drivers.forEach(System.out::println);

        TreeSet<Person> passengers = Stream.of(randomGroupOfPersons)
                .filter(Person::isPassenger)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))));

        System.out.println("\nPassengers sorted by name:");
        passengers.forEach(System.out::println);
        System.out.println();


        Problem problem = new Problem(drivers, randomGroupOfPersons);

        problem.computeListOfAllDestinations();
        System.out.println("Here we got the list of destinations: \n" + problem.getListOfDestinations());

        System.out.println();

        var listOfDestinations = problem.computeListOfAllPersonsAndDestinations();
        listOfDestinations.forEach((destination,people) -> {
            System.out.println("Destination: " + destination);
            System.out.println("Interested people: " + people.stream()
                    .map(Person::getName)
                    .collect(Collectors.joining(", ")));
            System.out.println("----------------------------------");
        });
    }
}
