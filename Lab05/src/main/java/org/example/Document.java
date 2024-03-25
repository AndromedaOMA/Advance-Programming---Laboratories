package org.example;

public record Document(String title) {
    public Document(String title) {
        this.title=title;
    }
}
