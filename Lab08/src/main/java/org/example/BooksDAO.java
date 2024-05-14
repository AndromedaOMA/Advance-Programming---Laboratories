package org.example;

import java.sql.*;

class BooksDAO {
    public void create(String title, String language, int numPage, int authorId) throws SQLException {
        if (findByTitle(title) != null) {
            System.out.println("The book '" + title + "' already exists.");
        } else {
            try (Connection con = Database.getConnection();
                 PreparedStatement pstmt = con.prepareStatement(
                         "INSERT INTO books (title, language, num_pages, author_id) VALUES (?, ?, ?, ?)")) {
                pstmt.setString(1, title);
                pstmt.setString(2, language);
                pstmt.setInt(3, numPage);
                pstmt.setInt(4, authorId);
                pstmt.executeUpdate();
            }
        }
    }

    public Integer findByTitle(String title) throws SQLException {
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT book_id FROM books WHERE title=?")) {
            pstmt.setString(1, title);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
    }

    public void listBooks() {
        try (Connection con = Database.getConnection();
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery("SELECT * FROM books")) {
            while (resultSet.next()) {
                System.out.println("Book ID: " + resultSet.getInt("BOOK_ID") +
                        ", Title: " + resultSet.getString("TITLE") +
                        ", Language: " + resultSet.getString("LANGUAGE") +
                        ", No. Pages: " + resultSet.getInt("NUM_PAGES") +
                        ", Author ID: " + resultSet.getInt("author_id"));
            }
        } catch (SQLException e) {
            System.err.println("Error listing books: " + e.getMessage());
        }
    }
}

