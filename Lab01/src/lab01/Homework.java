/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab01;
import java.util.ArrayList;

/**
 *
 * @author mariu
 */
public class Homework {

    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        ArrayList<String> ar = new ArrayList<String>();

        for (int i = a; i <= b; i++) {
            int result = 0;
            while (i != 0) {
                result += i % 10;
                i /= 10;
                if (result >= 10 && i == 0) {
                    i = result;
                    result = 0;
                }
            }
            if (result % k == 0) {
                ar.add(Integer.toString(i));
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}
