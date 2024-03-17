import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

class Statue implements Visitable {
    private String name;

    Map<LocalDate, TimeInterval> timeTable = new HashMap<LocalDate, TimeInterval>() {{
        put(LocalDate.of(2024, 3, 16), new TimeInterval(LocalTime.of(10, 0), LocalTime.of(10, 20)));
        put(LocalDate.of(2024, 5, 15), new TimeInterval(LocalTime.of(11, 0), LocalTime.of(10, 20)));
        put(LocalDate.of(2024, 1, 1), new TimeInterval(LocalTime.of(12, 0), LocalTime.of(10, 20)));
    }};

    public Statue(String name) {
        this.name = name;
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return this.timeTable;
    }

    @Override
    public void visit() {
        System.out.println("Visiting " + name + " statue only on: " + getTimetable());
    }
}