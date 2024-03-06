import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Client c1 = new Client("Marius", LocalTime.NOON, LocalTime.MIDNIGHT, ClientType.PREMIUM);
        System.out.println(c1);

        Client c2 = new Client("Andrei", LocalTime.of(10, 0), LocalTime.of(12, 0), ClientType.REGULAR);
        System.out.println(c2);

        Vehicle v1 = new Vehicle("Dacia");
        System.out.println(v1);

        Depot d1 = new Depot("LaNoi");
        System.out.println(d1);
    }
}