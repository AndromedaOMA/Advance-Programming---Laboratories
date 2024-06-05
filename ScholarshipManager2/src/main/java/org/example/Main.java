package org.example;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        register r = new register();
        r.setContentPane(r.panelMain);
        r.setTitle("Register");
        r.setSize(300, 400);
        r.setVisible(true);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}