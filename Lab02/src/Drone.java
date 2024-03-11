public class Drone extends Vehicle {
    private int flightDuration;

    public Drone(String name, int flightDuration) {
        super(name);
        this.flightDuration=flightDuration;
    }

    public void setFlightDuration(int flightDuration){
        this.flightDuration=flightDuration;
    }

    public int getFlightDuration(){
        return this.flightDuration;
    }
}
