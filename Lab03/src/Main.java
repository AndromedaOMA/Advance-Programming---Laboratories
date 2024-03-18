public class Main {
    public static void main(String[] args) {
        // Create attractions
        Statue statue = new Statue("Statue of Liberty");
        Church church = new Church("St. Patrick's Cathedral", 10.0);
        Concert concert = new Concert("Symphony Orchestra", 25.0);

        // Create a trip
        Trip trip = new Trip("New York", 3);

        // Add attractions to the trip
        trip.addAttraction(statue);
        trip.addAttraction(church);
        trip.addAttraction(concert);

        // Start the trip
        trip.startTrip();

        trip.displayVisitableAndNonPayableAttractions();
        System.out.println();

        TravelPlan plan = new TravelPlan(trip.getAttractions());
        //Found the day to visit all the attractions
        plan.getThePerfectDay();
        System.out.println();

        //found the DAYS to visit EACH the attraction
        //first heuristic:
        plan.getThePerfectDayRandomized(trip);
        System.out.println();
        //second heuristic:
        plan.getThePerfectDayGreedy(trip);
    }
}