package org.example;

import java.sql.*;

class AuthorDAO {
    public void create(String name) throws SQLException {
        if (findByName(name) != null) {
            System.out.println("Author '" + name + "' already exists.");
        } else {
            try (Connection con = Database.getConnection();
                 PreparedStatement pstmt = con.prepareStatement("INSERT INTO authors (name) VALUES (?)")) {
                pstmt.setString(1, name);
                pstmt.executeUpdate();
            }
        }
    }

    public Integer findByName(String name) throws SQLException {
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT author_id FROM authors WHERE name=?")) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
    }

    public void listAuthors() {
        try (Connection con = Database.getConnection();
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery("SELECT * FROM authors")) {
            while (resultSet.next()) {
                System.out.println("Author ID: " + resultSet.getInt("AUTHOR_ID") +
                        ", Name: " + resultSet.getString("NAME"));
            }
        } catch (SQLException e) {
            System.err.println("Error listing authors: " + e.getMessage());
        }
    }
}

