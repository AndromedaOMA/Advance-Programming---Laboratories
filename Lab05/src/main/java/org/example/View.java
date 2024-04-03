package org.example;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class View implements Command {

    public void execute(String[] args) throws CommandException {
        if (args.length != 1) {
            throw new CommandException("Invalid arguments.");
        }
        String document = args[0];
        Path filePath = Paths.get(document);
        if (!Files.exists(filePath)) {
            throw new CommandException("File not found: " + document);
        }

        try {
            Desktop.getDesktop().open(filePath.toFile());
        } catch (IOException e) {
            throw new CommandException("Failed to open document: " + e.getMessage());
        }
    }
}