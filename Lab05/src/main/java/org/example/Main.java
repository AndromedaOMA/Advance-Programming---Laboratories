package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Compulsory
        System.out.println("Compulsory");
        Repository repo = new Repository("D:\\Windows_Folders\\FACULTATE\\Cursuri an II\\Sem II\\Advance-Programming---Laboratories");
        repo.readFiles();

        //Homework
        System.out.println();
        System.out.println("Homework");
        System.out.println("Welcome to my personal Shell: \n \t You can type the command \"view\" and an path to open it via Desktop!");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write the command: ");
            String input = scanner.nextLine();
            String[] parts = input.split("\\s+");

            String commandName = parts[0];
            Command command;
            switch (commandName) {
                case "view":
                    command = new View();
                    break;
                default:
                    System.out.println("Invalid command.");
                    continue;
            }
            try {
                String[] arguments;
                if (parts.length > 1) {
                    arguments = Arrays.copyOfRange(parts, 1, parts.length);
                } else {
                    arguments = new String[0];
                }
                command.execute(arguments);
            } catch (CommandException e) {
                System.out.println("Error executing command: " + e.getMessage());
            }
        }
    }
}