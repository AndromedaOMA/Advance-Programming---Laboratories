package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Declararea tabloului
        Set[] tablou = new Set[2];

        // Instanțierea elementelor tabloului
        tablou[0] = new HashSet<>();
        tablou[1] = Collections.singleton(new ArrayList<>());

        // Adăugarea elementelor în set și listă
        tablou[0].add("Element1");
        tablou[0].add("Element2");

        tablou[1].add("Element3");
        tablou[1].add("Element4");

        // Afisarea elementelor din set și listă
        System.out.println("Set: " + tablou[0]);
        System.out.println("List: " + tablou[1]);
    }
}
