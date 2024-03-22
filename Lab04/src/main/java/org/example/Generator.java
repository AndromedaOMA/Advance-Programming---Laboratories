package org.example;

import com.github.javafaker.Faker;

import java.util.Random;
import java.util.stream.Stream;

public class Generator {
    public static Person[] generateRandomListOfPersons(int minLimit, int maxLimit) throws InterruptedException {
//      var names = new String[]{"John", "Emily", "Michael", "Sophia", "David", "Emma", "Daniel", "Olivia", "Matthew", "Ava", "Andrew", "Isabella", "James", "Mia", "Sarah", "Benjamin", "Charlotte", "Alexander", "Amelia", "William"};
        var destinations = new String[]{"Piatra Neamt", "Bucuresti", "Iasi", "Timisoara"};
        var rand = new Random();
        int numberOfPersons = rand.nextInt(maxLimit - minLimit + 1) + minLimit;

        return Stream.generate(() -> {
            Faker faker = new Faker();
            String fakeName = faker.name().fullName();
            //String fakeAddress = faker.address().city();
            //var name = names[rand.nextInt(names.length)];
            var age = rand.nextInt(30) + 18;
            var destination = destinations[rand.nextInt(destinations.length)];
            boolean isDriver = rand.nextBoolean();
            if (isDriver) {
                return new Driver(fakeName, age, destination);
            } else {
                return new Passenger(fakeName, age, destination);
            }
        }).limit(numberOfPersons).toArray(Person[]::new);
    }
}
