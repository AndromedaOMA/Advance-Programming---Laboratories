class Statue implements Visitable {
    private String name;

    public Statue(String name) {
        this.name = name;
    }

    @Override
    public void visit() {
        System.out.println("Visiting " + name + " statue");
    }
}