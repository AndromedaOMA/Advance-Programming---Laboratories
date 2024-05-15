package org.example;

import java.sql.*;

public class GenreDAO {
    public void create(String name) throws SQLException {
        if (findByName(name) != null) {
            System.out.println("Genre '" + name + "' already exists.");
        } else {
            try (Connection con = Database.getConnection();
                 PreparedStatement pstmt = con.prepareStatement("INSERT INTO genre_final (name) VALUES (?)")) {
                pstmt.setString(1, name);
                pstmt.executeUpdate();
            }
        }
    }

    public Integer findByName(String name) throws SQLException {
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT genre_id FROM genre_final WHERE name=?")) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
    }

    public void listGenres() {
        try (Connection con = Database.getConnection();
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery("SELECT * FROM genre_final")) {
            while (resultSet.next()) {
                System.out.println("Genre ID: " + resultSet.getInt("GENRE_ID") +
                        ", Name: " + resultSet.getString("NAME"));
            }
        } catch (SQLException e) {
            System.err.println("Error listing genres: " + e.getMessage());
        }
    }
}
