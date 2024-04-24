package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            var authorDAO = new AuthorDAO();
            authorDAO.create("William Shakespeare");
            authorDAO.create("Peter Thiel");

            authorDAO.listAuthors();

            var genreDAO = new GenreDAO();
            genreDAO.create("Tragedy");
            genreDAO.create("Financial");

            var bookDAO = new BooksDAO();
            int shakespeareId = authorDAO.findByName("William Shakespeare");
            int tragedyId = genreDAO.findByName("Tragedy");

            int blakeId = authorDAO.findByName("Peter Thiel");
            int financialId = genreDAO.findByName("Financial");

//            bookDAO.create(1597, "Romeo and Juliet", shakespeareId, tragedyId);
//            bookDAO.create(2014, "Zero to One", blakeId, financialId);

            bookDAO.create("Romeo and Juliet", "eng", 300 , shakespeareId);
            bookDAO.create("Zero to One", "ro", 250, blakeId);

            bookDAO.listBooks();

            Database.getConnection().commit();


            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            Database.closeConnection();
        }
    }
}
