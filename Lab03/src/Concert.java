class Concert implements Visitable, Payable {
    private String name;
    private double ticketPrice;

    public Concert(String name, double ticketPrice) {
        this.name = name;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public void visit() {
        System.out.println("Attending " + name + " concert" + "with ticketPrice = " + ticketPrice);
    }

    @Override
    public double getPrice() {
        return ticketPrice;
    }
}