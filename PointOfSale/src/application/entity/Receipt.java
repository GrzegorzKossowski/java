package application.entity;

/**
 * PointOfSale
 * Created by Grzegorz Kossowski on 18.03.17.
 * Receipt entity - kind of DTO
 */
public class Receipt {

    private String name;
    private double price;

    public Receipt(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
