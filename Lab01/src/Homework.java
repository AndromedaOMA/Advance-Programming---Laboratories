import java.util.ArrayList;

public class Homework {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        ArrayList<String> ar = new ArrayList<>();

        for (int i = a; i <= b; ++i) {
            int result = 0;
            int currentValue=i;

            while (currentValue != 0) {
                result += currentValue % 10;
                currentValue /= 10;
                if (result >= 10 && currentValue == 0) {
                    currentValue = result;
                    result = 0;
                }
            }

            if (result % k == 0) {
                ar.add(Integer.toString(i));
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.println(ar);
        System.out.println("The Homework class runs in " + (t2 - t1) + " miliseconds!");
    }
}
