import java.time.LocalTime;

public class Client {
    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;
    private ClientType type;
    private final double timeClientToClient = (int) (Math.random() * 10);
    private final double timeDepotToClient = (int) (Math.random() * 10 + 10);

    public Client(String name, LocalTime minTime, LocalTime maxTime, ClientType type) {
        this.name = name;
        this.maxTime = maxTime;
        this.minTime = minTime;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    public void setType(ClientType type) {
        this.type = type;
    }


    public String getName() {
        return this.name;
    }

    public LocalTime getMinTime() {
        return this.minTime;
    }

    public LocalTime getMaxTime() {
        return this.maxTime;
    }

    public ClientType getType() {
        return this.type;
    }

    public double getTimeClientToClient() {
        return this.timeClientToClient;
    }

    public double getTimeDepotToClient() {
        return this.timeDepotToClient;
    }

    @Override
    public String toString() {
        return "Client(" + getName() + ", " + getMinTime() + ", " + getMaxTime() + ", " + getType() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Client)) return false;
        Client other = (Client) obj;
        return name.equals(other.name) && type.equals(other.type);
    }
}
