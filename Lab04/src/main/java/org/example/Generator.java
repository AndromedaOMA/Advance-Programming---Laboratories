package org.example;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Generator {
    public static Person[] generateRandomListOfPersons(int minLimit, int maxLimit) {
        var names = new String[]{"Marius", "Alexandru", "Olaru", "Codrin", "Andrei", "Sandu"};
        var destinations = new String[]{"Piatra Neamt", "Bucuresti", "Iasi", "Oradea", "Bacau", "Timisoara"};
        var rand = new Random();
        int numberOfPersons = rand.nextInt(maxLimit - minLimit + 1) + minLimit;

        return Stream.generate(() -> {
            var name = names[rand.nextInt(names.length)];
            var age = rand.nextInt(30) + 18;
            var destination = destinations[rand.nextInt(destinations.length)];
            boolean isDriver = rand.nextBoolean();
            if (isDriver) {
                return new Driver(name, age, destination);
            } else {
                return new Passenger(name, age, destination);
            }
        }).limit(numberOfPersons).toArray(Person[]::new);
    }
}
