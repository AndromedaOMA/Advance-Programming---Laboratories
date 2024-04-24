//package org.example;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DbConnection {
//    private static final String URL = "jdbc:postgresql://localhost:5432/books";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "password";
//    private static Connection connection = null;
//
//    private DbConnection() {
//    }
//
//    public static Connection getConnection() throws SQLException {
//        if (connection == null || connection.isClosed()) {
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//        }
//        return connection;
//    }
//
//    public static void executeSqlScript(String scriptFileName) {
//        try (InputStream inputStream = DbConnection.class.getResourceAsStream("/" + scriptFileName);
//             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//             Connection connection = getConnection();
//             Statement statement = connection.createStatement()) {
//
//            StringBuilder scriptContent = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                scriptContent.append(line).append("\n");
//            }
//
//            statement.execute(scriptContent.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
