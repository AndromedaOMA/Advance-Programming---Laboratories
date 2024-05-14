package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthorDAO {
//    public void create(String name) throws SQLException {
//        Connection con = Database.getConnection();
//        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO authors (name) VALUES (?)")) {
//            pstmt.setString(1, name);
//            pstmt.executeUpdate();
//        }
//    }
    public void create(String name) throws SQLException {

        if (findByName(name) != null) {
            System.out.println("Author '" + name + "' already exists.");
            return;
        } else {
            Connection con = Database.getConnection();
            try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO authors (name) VALUES (?)")) {
                pstmt.setString(1, name);
                pstmt.executeUpdate();
            }
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT author_id FROM authors WHERE name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name FROM authors WHERE author_id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public void addAuthor(String name) {
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO authors (name) VALUES (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }
}
