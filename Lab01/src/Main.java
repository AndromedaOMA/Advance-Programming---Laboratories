import java.lang.Math;

public class Main {

    public static void main(String[] args) {

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