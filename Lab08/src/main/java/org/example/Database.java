package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/books";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static final Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        // TODO
        return ;
    }

    private static void createConnection() {
        try {
            Connection = // TODO;
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() {
        // TODO
    }
}