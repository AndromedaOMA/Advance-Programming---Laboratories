package org.example;

import java.io.File;
import java.io.FileReader;

public class Repository {
    String path;

    public Repository(String path) {
        this.path = path;
    }

    public void readFiles() {
        File directory = new File(this.path);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory not found or is not a directory.");
            return;
        }
        System.out.println("The given directory contains the following files:");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("Person ID: " + file.getName());
                }
            }
        } else {
            System.out.println("No file found...");
        }
    }
}
