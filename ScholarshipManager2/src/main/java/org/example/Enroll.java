package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Enroll extends JFrame {
    private JCheckBox AICheckBox;
    private JCheckBox NNCheckBox;
    private JCheckBox MLCheckBox;
    private JCheckBox pythonCheckBox;
    private JButton submitButton;
    JPanel paneEnroll;

    public Enroll() {
        submitButton.addActionListener(new ActionListener() {
            private int tuitionBalance;
            private static final int costOfCourse = 600;

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedCourses = 0;

                if (AICheckBox.isSelected()) {
                    selectedCourses++;
                }
                if (NNCheckBox.isSelected()) {
                    selectedCourses++;
                }
                if (MLCheckBox.isSelected()) {
                    selectedCourses++;
                }
                if (pythonCheckBox.isSelected()) {
                    selectedCourses++;
                }

                tuitionBalance = selectedCourses * costOfCourse;

                String studentInfo = " Tuition Balance: $" + tuitionBalance;
                JOptionPane.showMessageDialog(submitButton, studentInfo);
            }
        });
    }
}
