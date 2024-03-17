import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

class Concert implements Visitable, Payable {
    private String name;
    private double ticketPrice;

    Map<LocalDate, TimeInterval> timeTable = new HashMap<LocalDate, TimeInterval>() {{
        put(LocalDate.of(2024, 1, 16), new TimeInterval(LocalTime.of(10, 0), LocalTime.of(10, 20)));
        put(LocalDate.of(2024, 4, 1), new TimeInterval(LocalTime.of(11, 0), LocalTime.of(10, 20)));
        put(LocalDate.of(2024, 1, 1), new TimeInterval(LocalTime.of(12, 0), LocalTime.of(10, 20)));
    }};

    public Concert(String name, double ticketPrice) {
        this.name = name;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return this.timeTable;
    }

    @Override
    public void visit() {
        System.out.println("Attending " + name + " concert" + "with ticketPrice = " + ticketPrice + " only on: " + getTimetable());
    }

    @Override
    public double getPrice() {
        return ticketPrice;
    }
}