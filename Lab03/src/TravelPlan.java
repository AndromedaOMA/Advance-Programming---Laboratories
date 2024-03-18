import java.time.LocalDate;
import java.util.*;

public class TravelPlan {
    private final List<Visitable> attractions;

    public TravelPlan(List<Visitable> attractions) {
        this.attractions = attractions;
    }

    void getThePerfectDay() {
        List<LocalDate[]> listOfDateArrays = new ArrayList<>();

        for (Visitable obj : attractions) {
            listOfDateArrays.add(obj.getDaysOfVisiting());
        }

//        Set<List<LocalDate>> setOfLists = new HashSet();
//        for (LocalDate[] obj : listOfDateArrays) {
//            List<LocalDate[]> list = (List<LocalDate[]>) Arrays.asList(obj);
//            setOfLists.add((List<LocalDate>) list);
//        }

        for (LocalDate[] currentDate : listOfDateArrays) {
            for (LocalDate date : currentDate) {
                boolean valid = true;

                for (LocalDate[] array : listOfDateArrays) {
                    if (!containsDate(array, date)) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    System.out.println("The perfect day is: " + date);
                    return;
                }
            }
        }
    }

    private boolean containsDate(LocalDate[] array, LocalDate date) {
        for (LocalDate d : array) {
            if (d != null && d.equals(date)) {
                return true;
            }
        }
        return false;
    }

    void getThePerfectDayRandomized(Trip trip) {
        Map<Visitable, Integer> colorMap = new HashMap<>();
        List<Visitable> uncoloredAttractions = new ArrayList<>(attractions);

        if (trip.getPeriod() < attractions.size()) {
            System.out.println("Insufficient days of travel too plan the trip!");
        } else {
            // Assign colors to attractions randomly until all are colored
            while (!uncoloredAttractions.isEmpty()) {
                Visitable attraction = uncoloredAttractions.removeFirst();
                int color = new Random().nextInt(attractions.size()); // Random color assignment
                colorMap.put(attraction, color);
            }

            for (Map.Entry<Visitable, Integer> entry : colorMap.entrySet()) {
                System.out.println(entry.getKey() + " -> Day " + entry.getValue());
            }
        }


    }

    void getThePerfectDayGreedy(Trip trip) {
        Map<Visitable, Integer> colorMap = new HashMap<>();
        Set<Integer> usedColors = new HashSet<>();
        int maxColor = 0;

        if (trip.getPeriod() < attractions.size()) {
            System.out.println("Insufficient days of travel too plan the trip!");
        } else {
            // Iterate through attractions
            for (Visitable attraction : attractions) {
                Set<Integer> adjacentColors = new HashSet<>();

                // Find adjacent attractions and their colors
                for (Visitable adjacent : attractions) {
                    if (attraction != adjacent && conflicts(attraction, adjacent)) {
                        if (colorMap.containsKey(adjacent)) {
                            adjacentColors.add(colorMap.get(adjacent));
                        }
                    }
                }

                // Assign the smallest available color
                for (int color = 0; color <= maxColor; color++) {
                    if (!adjacentColors.contains(color)) {
                        colorMap.put(attraction, color);
                        usedColors.add(color);
                        break;
                    }
                }

                // Update maxColor if necessary
                if (usedColors.size() > maxColor) {
                    maxColor++;
                }
            }

            for (Map.Entry<Visitable, Integer> entry : colorMap.entrySet()) {
                System.out.println(entry.getKey() + " -> Day " + entry.getValue());
            }
        }
    }

    // Check if two attractions conflict in terms of visiting days
    private boolean conflicts(Visitable attraction1, Visitable attraction2) {
        LocalDate[] days1 = attraction1.getDaysOfVisiting();
        LocalDate[] days2 = attraction2.getDaysOfVisiting();

        for (LocalDate day1 : days1) {
            for (LocalDate day2 : days2) {
                if (day1.equals(day2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
