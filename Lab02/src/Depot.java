public class Depot {
    private String name;
    private Vehicle[] vehicles;

    public Depot(String name) {
        this.name=name;
    }

    public void setName(String name) {
        this.name=name;
    }

//    public void setVehicles(Vehicle[] vehicles) {
//        for ( int i=0;i<vehicles.length;i++)
//                this.vehicles=vehicles[i];
//    }

    public String getName() {
        return this.name;
    }
    @Override
    public String toString(){
        return "Depot(" + getName() + ")";
    }

//    public void setVehicles(Vehicle ... vehicles) {
//        this.vehicles = vehicles;
//        for(Vehicles v : vehicles)
//            v.setDepot(this);
}
