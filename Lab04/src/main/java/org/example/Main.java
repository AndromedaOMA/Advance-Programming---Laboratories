package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Person[] randomGroupOfPersons = Generator.generateRandomListOfPersons(5, 10);

        for (Person person : randomGroupOfPersons) {
            System.out.println(person.toString());
        }

        LinkedList<Person> drivers = Stream.of(randomGroupOfPersons)
                .filter(Person::isDriver)
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("\nDrivers sorted by age:");
        if (drivers.isEmpty()) {
            System.out.println("No drivers found.");
        } else {
            drivers.forEach(System.out::println);
        }

        TreeSet<Person> passengers = Stream.of(randomGroupOfPersons)
                .filter(Person::isPassenger)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))));

        System.out.println("\nPassengers sorted by name:");
        if (drivers.isEmpty()) {
            System.out.println("No passengers found.");
        } else {
            passengers.forEach(System.out::println);
        }
        System.out.println();


        Problem problem = new Problem(drivers, randomGroupOfPersons);

        problem.computeListOfAllDestinations();
        System.out.println("Here we got the list of drivers destinations: \n" + problem.getListOfDestinations());

        System.out.println();

        var listOfDestinations = problem.computeListOfAllPersonsAndDestinations();
        listOfDestinations.forEach((destination, people) -> {
            System.out.println("Destination: " + destination);
            System.out.println("Interested people: " + people.stream()
                    .map(Person::getName)
                    .collect(Collectors.joining(", ")));
            System.out.println("----------------------------------");
        });

        //Problem solver
        boolean ok=false;
        if (drivers.isEmpty()) {
            System.out.println("There are no drivers!");
        } else {
            listOfDestinations.forEach((currentDestination, value) -> {
                List<Person> listOfPassengers = value.stream()
                        .filter(Person::isPassenger)
                        .toList();
                List<Person> listOfDrivers = value.stream()
                        .filter(Person::isDriver)
                        .toList();
                int index = 0;
                for (Person currentDriver : listOfDrivers) {
                    if (!listOfPassengers.isEmpty()) {
                        System.out.println(currentDriver.getName() + " drives " + listOfPassengers.get(index++).getName() + " at " + currentDestination);
                    } else {
                        System.out.println(currentDriver.getName() + " don't have any passengers to drive at " + currentDestination);
                    }
                }
            });
        }
    }
}
