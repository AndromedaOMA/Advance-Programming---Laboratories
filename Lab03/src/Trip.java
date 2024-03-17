import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Trip {
    private final String cityName;
    private final String period;
    private final List<Visitable> attractions;

    public Trip(String cityName, String period) {
        this.cityName = cityName;
        this.period = period;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Visitable attraction) {
        attractions.add(attraction);
    }

    public void startTrip() {
        System.out.println();
        System.out.println("===> Welcome to " + cityName + " for the " + period + " trip!");
        System.out.println("===> Here are the attractions:");

        // Visit each attraction
        for (Visitable attraction : attractions) {
            attraction.visit();
            System.out.println();
        }
    }

    public  List<Visitable> getAttractions(){
        return this.attractions;
    }

    // Method to sort locations by start time
    public static void sortLocationsByStartTime(List<Visitable> attractions) {
        attractions.sort(Comparator.comparing(attraction -> {
            // Get the opening hour for each attraction
            LocalTime openingHour = attraction.getOpeningHour(LocalDate.now());
            // Handle the case where openingHour might be null
            // You may want to define a default opening hour or handle null differently
            return openingHour != null ? openingHour : LocalTime.MAX;
        }));
    }

    public void displayVisitableAndNonPayableAttractions() {
        List<Visitable> filteredAttractions = new ArrayList<>();
        for (Visitable obj : this.attractions)
            if (obj instanceof Visitable && !(obj instanceof Payable)) {
                filteredAttractions.add(obj);
            }
        if (filteredAttractions.isEmpty()) {
            System.out.println("Here are no visitable and non payable attractions!");
        } else {
            sortLocationsByStartTime(filteredAttractions);
            System.out.println("Here we got out filtered attractions that are visitable and non payable: " + filteredAttractions);
        }
    }
}