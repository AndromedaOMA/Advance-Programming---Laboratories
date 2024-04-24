package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) {
        try {
            var authors = new AuthorDAO();
            authors.create("William Shakespeare");
            var genres = new GenreDAO();
            genres.create("Tragedy");
            Database.getConnection().commit();
            var books = new BookDAO();            //findByName
            books.create(1597, "Romeo and Juliet", "William Shakespeare", "Tragedy");
            books.create(1979, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Science fiction, Comedy, Adventure");
            Database.getConnection().commit();

            //TODO: print all the books in the database

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}