/*
* This class contains description about service such as service name, price
* This approach is better if you want to use the service data elsewhere in your program.
 * */

class Service {
    private String name;
    private double price;

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{service: '" + name + "', price: " + price + "}";
    }
}
