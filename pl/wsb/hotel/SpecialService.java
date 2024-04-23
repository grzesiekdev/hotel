package pl.wsb.hotel;

abstract class SpecialService {
    private String name;

    abstract void orderService();
    abstract int calculateCost();
    abstract String confirmService();

    public SpecialService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SpecialService{" +
                "name='" + name + '\'' +
                '}';
    }
}
