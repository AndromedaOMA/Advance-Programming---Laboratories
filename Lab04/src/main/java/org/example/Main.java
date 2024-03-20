package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> listOfPersons = new ArrayList<>();
        Person[] randomGroupOfPersons = Generator.generateRandomListOfPersons(5, 10);

        for (Person person : randomGroupOfPersons) {
            System.out.println(person.toString());
            System.out.println();
        }

        
    }
}