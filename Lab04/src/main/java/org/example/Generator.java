package org.example;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Generator {
    public static Person[] generateRandomListOfPersons(int minLimit, int maxLimit) {
        var names = new String[]{"Marius", "Alexandru", "Olaru", "Codrin", "Andrei", "Sandu"};
        var rand = new Random();
        int numberOfPersons = rand.nextInt(maxLimit - minLimit + 1) + minLimit;

//        String currentName = name[rand.nextInt(name.length)];
//        boolean isDriver = rand.nextBoolean();
//        int currentAge = rand.nextInt(50) + 18;
//        var groupOfPersons = IntStream.rangeClosed(0, numberOfPersons)
//                .mapToObj(i -> new Person(name[rand.nextInt(name.length)],
//                        rand.nextInt(50) + 18,
//                        rand.nextBoolean(),
//                        !rand.nextBoolean())).toArray(Person[]::new);


        Person[] groupOfPersons = Stream.generate(() ->
                        new Person(names[rand.nextInt(names.length)],
                                rand.nextInt(50) + 18,
                                rand.nextBoolean(),
                                !rand.nextBoolean()))
                .limit(numberOfPersons)
                .toArray(Person[]::new);

//        var groupOfPersons = new Person[numberOfPersons];
//        for (int index = 0; index < numberOfPersons; index++) {
//            String currentName = name[rand.nextInt(name.length)];
//            boolean isDriver = rand.nextBoolean();
//            int currentAge = rand.nextInt(50) + 18;
//            groupOfPersons[index] = new Person(currentName, currentAge, isDriver, !isDriver);
//        }

        return groupOfPersons;
    }
}
