import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /**
         *  Here we create our first clients, the vehicles and the depots, then we will print them
         */
        Client c1 = new Client("Marius", LocalTime.NOON, LocalTime.MIDNIGHT, ClientType.PREMIUM);
        Client c2 = new Client("Andrei", LocalTime.of(10, 0), LocalTime.of(12, 0), ClientType.REGULAR);

        Vehicle v1 = new Drone("Drone000", 10);
        Vehicle v2 = new Truck("Truck001", 120);
        Vehicle v3 = new Truck("Truck002", 100);

        Depot d1 = new Depot("Depot 1");
        d1.setVehicles(v1, v2);
        Depot d2 = new Depot("Depot 2");
        d2.setVehicles(v3);


        System.out.println(c1);
        System.out.println(c2);

        System.out.println();

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        System.out.println();

        System.out.println(d1);
        System.out.println(d2);

        System.out.println();

        /**
         *  Here we get out array of clients for our Problem to distribute then to our cars using Greedy algorithm.
         *
         *  The method getVehicles in the Problem class, returning an array of all the vehicles, form all depots
         */
        Problem problem = new Problem(d1, d2);
        System.out.println(Arrays.toString(problem.getVehicles()));

        System.out.println();

        // Create a array of clients
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Client A", LocalTime.of(10, 0), LocalTime.of(12, 16), ClientType.REGULAR));
        clients.add(new Client("Client B", LocalTime.of(11, 14), LocalTime.of(11, 25), ClientType.PREMIUM));
        clients.add(new Client("Client C", LocalTime.of(10, 26), LocalTime.of(11, 30), ClientType.REGULAR));
        clients.add(new Client("Client D", LocalTime.of(10, 32), LocalTime.of(12, 20), ClientType.PREMIUM));

        // Allocate clients to vehicles
        problem.allocateClients(clients);
    }

//    class PersonComparator implements java.util.Comparator<Client> {
//        @Override
//        public int compare(Client a, Client b) {
//            return a.getMinTime() - b.getMinTime();
//        }
}