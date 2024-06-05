package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class register extends JFrame {
    private JButton registerButton;
    private JTextField fisrstNameField;
    private JTextField lastNameField;
    private JTextField gradeField;
    JPanel panelMain;

    public register() {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter student first name: ");
//        this.firstName = in.nextLine();
//        System.out.println("Enter student last name: ");
//        this.lastName = in.nextLine();
//        System.out.println("Enter student grade year: \n 1 - Freshmen \n 2 - Sophmore \n 3 - Junior \n 4 - Senior ");
//        this.gradeYear = in.nextInt();
//        System.out.println(this.firstName + " " + this.lastName + " " + this.gradeYear + " " + this.studentID);

        registerButton.addActionListener(new ActionListener() {
            private int titutionBalance;
            private static int costOfCourse = 600;
            private static int id = 1000;

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(registerButton, fisrstNameField.getText() + " " + lastNameField.getText() + " " + gradeField.getText() + " " + gradeField.getText() + "" + ++id);

                Enroll enrl = new Enroll();
                enrl.setContentPane(enrl.paneEnroll);
                enrl.setTitle("Enroll");
                enrl.setSize(300, 400);
                enrl.setVisible(true);
                enrl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
