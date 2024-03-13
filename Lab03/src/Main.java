public class Main {
    public static void main(String[] args) {
        // Create attractions
        Statue statue = new Statue("Statue of Liberty");
        Church church = new Church("St. Patrick's Cathedral", 10.0);
        Concert concert = new Concert("Symphony Orchestra", 25.0);

        // Create a trip
        Trip trip = new Trip("New York", "weekend");

        // Add attractions to the trip
        trip.addAttraction(statue);
        trip.addAttraction(church);
        trip.addAttraction(concert);

        // Start the trip
        trip.startTrip();
    }
}