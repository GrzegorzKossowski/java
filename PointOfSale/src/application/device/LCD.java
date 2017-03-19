package application.device;

import application.entity.Product;

/**
 * PointOfSale
 * Created by Grzegorz Kossowski on 18.03.17.
 * LCD device
 */
public class LCD {

    /**
     * Displaying name and price of product
     * @param product scanned product
     * @return
     */
    public static String printNameAndPrice(Product product) {
        double roundOff = (double) Math.round(product.getPrice() * 100) / 100;
        String msg = new String(product.getName() + ": " + roundOff + " btc");
        return msg;
    }

    /**
     * Displaying total sum of product prizes
     * @param totalPrice
     * @return
     */
    public static String printTotalSum(double totalPrice) {
        totalPrice = Math.round(totalPrice * 100.00) / 100.00;
        String msg = new String(totalPrice + " btc");
        return msg;
    }

    /**
     * Printing error msg
     * @return
     */
    public static String printErrorMsg() {
        return LcdMessage.ERROR.toString();
    }

    /**
     * Printing no-product msg
     * @return
     */
    public static String printProductNotFound() {
        return LcdMessage.NO_PRODUCT.toString();
    }

}
