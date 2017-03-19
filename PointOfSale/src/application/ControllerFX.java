package application;

import application.entity.Product;
import application.entity.Receipt;
import application.device.LCD;
import application.device.Scanner;
import application.service.ProductService;
import application.service.ProductServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerFX implements Initializable {

    @FXML
    private Label lcdLabel;
    @FXML
    private TextArea printer;
    @FXML
    private Button scanProductBtn;
    @FXML
    private Button exitScanBtn;

    private ProductService productService;
    private List<Receipt> receiptList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productService = new ProductServiceImpl();
        receiptList = new ArrayList<>();
        exitScanBtn.setDisable(true);
    }

    /**
     * Scanning product.
     * – if the product is found in products database than it's name and price is printed on LCD display
     * – if the product is not found than error message 'Product not found' is printed on LCD display
     * – if the code scanned is empty than error message 'Invalid bar-code' is printed on LCD display
     */
    @FXML
    public void scanProduct() {
        scanProductBtn.setDisable(true);
        String codeStr = Scanner.scanRandomProduct();
        if (codeStr.trim().isEmpty()) {
            rejectProductScan();
        } else {
            Product product = productService.getProduct(codeStr);
            if (product == null) {
                rejectProduct();
            } else {
                if (exitScanBtn.isDisable()) {
                    exitScanBtn.setDisable(false);
                }
                purchaseProduct(product);
            }
        }
        scanProductBtn.setDisable(false);
    }

    /**
     * when 'exit' is input than receipt is printed on printer containing a list of all previously scanned items names
     * and prices as well as total sum to be paid for all items; the total sum is also printed on LCD display
     */
    @FXML
    public void exitScan() {
        handleOrder();
        resetOrder();
    }

    /**
     * – if the product is found in products database than it's name and price is printed on LCD display
     * @param product scanned product
     */
    private void purchaseProduct(Product product) {
        lcdLabel.setText(LCD.printNameAndPrice(product));
        receiptList.add(new Receipt(product.getName(), product.getPrice()));
    }

    /**
     * – if the product is not found than error message 'Product not found' is printed on LCD display
     */
    private void rejectProduct() {
        lcdLabel.setText(LCD.printProductNotFound());
    }

    /**
     * – if the code scanned is empty than error message 'Invalid bar-code' is printed on LCD display
     */
    private void rejectProductScan() {
        lcdLabel.setText(LCD.printErrorMsg());
    }

    /**
     * Calculating totalprice, printing on LCD display, printing to printer (in this case - textarea 'printer')
     */
    private void handleOrder() {
        double totalPrice = calculateTotalSum(receiptList);
        totalPrice = Math.round(totalPrice * 100.00) / 100.00;
        lcdLabel.setText("Total: " + LCD.printTotalSum(totalPrice));
        String msgToPrinter = "";
        for(Receipt r : receiptList) {
//            msgToPrinter += r.getName() + "\t\t" + r.getPrice() + "\n";
            msgToPrinter += String.format("%s\t\t\t%s\n", r.getName(), r.getPrice());
        }
        msgToPrinter += "-----------\n";
        msgToPrinter += "Total price: " + totalPrice + " btc";
        printer.setText(msgToPrinter);
        msgToPrinter += "\n";
        System.out.println(msgToPrinter);
    }

    /**
     * reseting order - clearing receptList and disabling exit button
     */
    private void resetOrder() {
        receiptList.clear();
        exitScanBtn.setDisable(true);
    }

    /**
     * calculating total price of all products
     * @param receiptList
     * @return
     */
    private double calculateTotalSum(List<Receipt> receiptList) {
        double totalSum = 0.0d;
        for(Receipt r : receiptList) {
            totalSum += r.getPrice();
        }
        return totalSum;
    }

}
