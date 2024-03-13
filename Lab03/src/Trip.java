import java.util.ArrayList;
import java.util.List;

class Trip {
    private String cityName;
    private String period;
    private List<Visitable> attractions;

    public Trip(String cityName, String period) {
        this.cityName = cityName;
        this.period = period;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Visitable attraction) {
        attractions.add(attraction);
    }

    public void startTrip() {
        System.out.println("Welcome to " + cityName + " for the " + period + " trip!");
        System.out.println("Here are the attractions:");

        // Visit each attraction
        for (Visitable attraction : attractions) {
            attraction.visit();
        }
    }
}