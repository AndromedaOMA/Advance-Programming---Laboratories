import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TravelPlan {
    private final List<Visitable> attractions;

    public TravelPlan(List<Visitable> attractions) {
        this.attractions = attractions;
    }

    void getThePerfectDay() {
        List<LocalDate[]> listOfDateArrays = new ArrayList<>();
        int index = 0;
        for (Visitable obj : attractions) {
            listOfDateArrays.add(obj.getDaysOfVisiting());
        }

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
}
