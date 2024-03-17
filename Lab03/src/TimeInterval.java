import java.time.LocalTime;
import java.util.Objects;

class TimeInterval extends Pair<LocalTime, LocalTime> {
    protected TimeInterval(LocalTime first, LocalTime second) {
        super(first, second);
    }

    public LocalTime getStartTime(){
        return this.getFirst();
    }


//    @Override
//    public int hashCode() {
//        return Objects.hash(first, second);
//    }
}