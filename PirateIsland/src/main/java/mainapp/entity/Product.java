package mainapp.entity;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 29.01.17.
 */
//@Entity
public class Product {

    private String productName;
    private double productPrice;
    private int productAmount;

    public Product() {}

    public Product(String productName, double productPrice, int productAmount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productAmount=" + productAmount +
                '}';
    }
}
