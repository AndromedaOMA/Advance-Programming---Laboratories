package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ClassAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the fully qualified class name: ");
        String className = scanner.nextLine();

        try {
            Class<?> clazz = Class.forName(className);
            analyzeClass(clazz);
            runTests(clazz);
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + className);
            e.printStackTrace();
        }
    }

    public static void analyzeClass(Class<?> clazz) {
        System.out.println("Class: " + clazz.getName());
        System.out.println("Methods:");

        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(method.toString());
        }
    }

    public static void runTests(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                if (Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 0) {
                    try {
                        System.out.println("Running test: " + method.getName());
                        method.invoke(null);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
