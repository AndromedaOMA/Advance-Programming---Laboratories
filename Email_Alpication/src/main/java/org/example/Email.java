package org.example;

import java.util.Scanner;

public class Email {
    private String first_name;
    private String last_name;
    private String password;
    private String department;
    private int mailBoxCamacity;
    private String alternateEmail;

    public Email(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        System.out.println("Email Created: " + this.first_name + ' ' + this.last_name);

        this.department = setDepartment();
        System.out.println("Here is the department you selected: " + this.department);
    }

    public String setDepartment() {
        System.out.println("To select the department select \n 1 for sales \n 2 for IT \n 3 for PRM");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        in.close();

        switch (depChoice) {
            case 1:
                return "SALES";
            case 2:
                return "IT";
            case 3:
                return "PRM";
            default:
                return "";
        }
    }
}
