import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

class Church implements Visitable, Payable {
    private String name;
    private double entranceFee;

    Map<LocalDate, TimeInterval> timeTable = new HashMap<LocalDate, TimeInterval>() {{
        put(LocalDate.of(2024, 6, 16), new TimeInterval(LocalTime.of(10, 0), LocalTime.of(10, 20)));
        put(LocalDate.of(2024, 12, 15), new TimeInterval(LocalTime.of(11, 0), LocalTime.of(10, 20)));
        put(LocalDate.of(2024, 1, 1), new TimeInterval(LocalTime.of(12, 0), LocalTime.of(10, 20)));
    }};

    public Church(String name, double entranceFee) {
        this.name = name;
        this.entranceFee = entranceFee;
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return this.timeTable;
    }

    @Override
    public void visit() {
        System.out.println("Visiting " + name + " church with entranceFee = " + entranceFee + " only on: " + getTimetable());
    }

    @Override
    public double getPrice() {
        return entranceFee;
    }
}