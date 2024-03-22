package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    List<String> listOfDestinations = new ArrayList<>();
    Map<String, List<Person>> mapOfPersonsAndDestinations = new HashMap<>();
    LinkedList<Person> listOfDrivers;
    Person[] randomGroupOfPersons;

    public Problem(LinkedList<Person> listOfDrivers, Person[] randomGroupOfPersons) {
        this.listOfDrivers=listOfDrivers;
        this.randomGroupOfPersons=randomGroupOfPersons;
        this.listOfDestinations=computeListOfAllDestinations();
        this.mapOfPersonsAndDestinations=computeListOfAllPersonsAndDestinations();
    }

    public List<String> getListOfDestinations() {
        return listOfDestinations;
    }

    public void setListOfDestinations(List<String> listOfDestinations) {
        this.listOfDestinations = listOfDestinations;
    }

    public Map<String, List<Person>> getMapOfPersonsAndDestinations() {
        return mapOfPersonsAndDestinations;
    }

    public void setMapOfPersonsAndDestinations(Map<String, List<Person>> mapOfPersonsAndDestinations) {
        this.mapOfPersonsAndDestinations = mapOfPersonsAndDestinations;
    }

    public List<String> computeListOfAllDestinations(){
        return listOfDrivers.stream()
                .map(Person::getDestination)
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, List<Person>> computeListOfAllPersonsAndDestinations() {
        return Arrays.stream(randomGroupOfPersons)
                .collect(Collectors.groupingBy(Person::getDestination));
    }
}
