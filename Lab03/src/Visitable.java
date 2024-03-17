import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;

public interface Visitable {
    Map<LocalDate, TimeInterval> getTimetable();

    default LocalTime getOpeningHour(LocalDate date) {
        Map<LocalDate, TimeInterval> timetable = getTimetable();
        TimeInterval timeInterval = timetable.get(date);
        if (timeInterval != null) {
            return timeInterval.getStartTime();
        } else {
            return null;
        }
    }

    default LocalDate[] getDaysOfVisiting() {
        LocalDate[] daysOfVisiting = new LocalDate[100];
        int index = 0;
        Map<LocalDate, TimeInterval> timetable = getTimetable();

        for (Map.Entry<LocalDate, TimeInterval> entry : timetable.entrySet()) {
            LocalDate date = entry.getKey();
            daysOfVisiting[index++] = date;
        }

        return daysOfVisiting;
    }

    void visit();
}