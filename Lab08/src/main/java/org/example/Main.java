package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            var authorDAO = new AuthorDAO();
            authorDAO.create("William Shakespeare");
            authorDAO.create("Peter Thiel");
            authorDAO.listAuthors();

            var bookDAO = new BooksDAO();

            int shakespeareId = authorDAO.findByName("William Shakespeare");
            int blakeId = authorDAO.findByName("Peter Thiel");

            bookDAO.create("Romeo and Juliet", "eng", 300 , shakespeareId);
            bookDAO.create("Zero to One", "ro", 250, blakeId);
            bookDAO.listBooks();

            Database.getConnection().commit();
        } catch (SQLException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            Database.closeConnection();
        }
    }
}
