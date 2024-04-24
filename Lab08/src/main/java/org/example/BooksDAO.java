package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BooksDAO {
    //    public void create(int publicationYear, String title, int authorId, int genreId) throws SQLException {
//        Connection con = Database.getConnection();
//        try (PreparedStatement pstmt = con.prepareStatement(
//                "INSERT INTO books (publication_year, title, author_id, genre_id) VALUES (?, ?, ?, ?)")) {
//            pstmt.setInt(1, publicationYear);
//            pstmt.setString(2, title);
//            pstmt.setInt(3, authorId);
//            pstmt.setInt(4, genreId);
//            pstmt.executeUpdate();
//        }
//    }
    public void create(String title, String language, int numPage, int authorId) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO books (title, language, num_pages, author_id) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, title);
            pstmt.setString(2, language);
            pstmt.setInt(3, numPage);
            pstmt.setInt(4, authorId);
            pstmt.executeUpdate();
        }
    }

    public void listBooks() throws SQLException {
        try (Connection con = Database.getConnection();
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery("SELECT * FROM books")) {
            while (resultSet.next()) {
                System.out.println("Book ID: " + resultSet.getInt("BOOK_ID") +
                        ", Title: " + resultSet.getString("TITLE") +
                        ", Language: " + resultSet.getString("LANGUAGE") +
                        ", Publication Date: " + resultSet.getInt("PUBLICATION_DATE") +
                        ", Author ID: " + resultSet.getInt("author_id") +
                        ", Genre ID: " + resultSet.getInt("NUM_PAGES"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
