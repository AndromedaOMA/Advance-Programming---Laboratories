/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab01;

import java.lang.Math;

/**
 *
 * @author mariu
 */
public class Lab01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        for (int iterator = 0; iterator < languages.length; iterator++) {
            System.out.println(languages[iterator]);
        }

        int n = (int) (Math.random() * 1_000_000);
        n *= 3;
        int decimal = Integer.parseInt("10101", 2);
        n += decimal;
        int hexaDecimal = Integer.parseInt("FF", 16);
        n += hexaDecimal;
        n *= 6;

        int result = 0;
        while (n != 0) {
            result += n % 10;
            n /= 10;
            if (result >= 10 && n == 0) {
                n = result;
                result = 0;
            }
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

}
