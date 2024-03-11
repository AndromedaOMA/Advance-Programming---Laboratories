public abstract class Vehicle {
    protected String name;
    protected Depot depot;

    public Vehicle(String name) {
        this.name = name;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Depot getDepot() {
        return this.depot;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Vehicle(" + getName() + ", " + getDepot() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) return false;
        Vehicle other = (Vehicle) obj;
        return name.equals(other.name) && depot.equals(other.depot);
    }
}
