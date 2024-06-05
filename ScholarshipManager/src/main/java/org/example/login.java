package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class login extends JFrame {
    private JTextField userText;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton loginButton;

    Connection conn=null;
    Statement stmt = null;
    ResultSet rs = null;

    public login() {
        JFrame frame = new JFrame("Login Frame");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250, 200));
        frame.setResizable(false);

        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
