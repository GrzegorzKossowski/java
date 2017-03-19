package application.device;

import java.util.ArrayList;
import java.util.List;

/**
 * PointOfSale
 * Created by Grzegorz Kossowski on 18.03.17.
 * Fake Scanner class, generates fake barcode input
 */
public class Scanner {

    /**
     * Fake skanned barcode numbers
     */
    public static List<String> numbers;

    //initialize fake numbers
    static {
        numbers = new ArrayList<String>() {
            {
                //products in DataBase
                add("59045678901234");
                add("59045678901235");
                add("59045678901236");
                add("59045678901237");
                add("59045678901238");
                add("59045678901239");
                //unnknown products
                add("45875486521458");
                add("32146945151252");
                add("12546964587421");
                //scanning error
                add("");
                add("");
                add("");
            }
        };
    }

    /**
     * Method imitates external scanner that returns bar code
     * @return productNumber GTIN 14 digit number of scanned product
     */
    public static String scanRandomProduct() {
        int listSize = numbers.size();
        int randomListIndex = (int) (Math.random() * (listSize));
        return numbers.get(randomListIndex);
    }

}
