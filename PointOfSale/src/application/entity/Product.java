package application.entity;

/**
 * PointOfSale
 * Created by Grzegorz Kossowski on 17.03.17.
 * Product entity
 */
public class Product {

    private String code;
    private String name;
    private double price;

    public Product() { }

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
