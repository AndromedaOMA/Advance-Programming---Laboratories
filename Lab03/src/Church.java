class Church implements Visitable, Payable {
    private String name;
    private double entranceFee;

    public Church(String name, double entranceFee) {
        this.name = name;
        this.entranceFee = entranceFee;
    }

    @Override
    public void visit() {
        System.out.println("Visiting " + name + " church with entranceFee = " + entranceFee);
    }

    @Override
    public double getPrice() {
        return entranceFee;
    }
}