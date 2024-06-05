package org.example;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class databaseConnection {
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost3306/java_project";

    final static String USER = "root";
    final static String PASS = "";

    public static Connection connection() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection (DB_URL, USER, PASS);
            return conn;
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
}
