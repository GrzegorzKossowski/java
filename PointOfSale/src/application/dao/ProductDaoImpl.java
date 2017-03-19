package application.dao;

import application.entity.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * PointOfSale
 * Created by Grzegorz Kossowski on 18.03.17.
 */
public class ProductDaoImpl implements ProductDao {

    /**
     * Fake database variable
     */
    private static Map<String, Product> products;

    //fake DataBase initialisation
    static {
        products = new HashMap<String, Product>() {
            {
                put("59045678901234", new Product("12345678901234", "Waciki", 12.32d));
                put("59045678901235", new Product("12345678901235", "Klapki", 30.31d));
                put("59045678901236", new Product("12345678901236", "Pompka", 20.42d));
                put("59045678901237", new Product("12345678901237", "Mydlo", 2.50d));
                put("59045678901238", new Product("12345678901238", "Wieszak", 10.00d));
                put("59045678901239", new Product("12345678901239", "Legoland", 120.20d));
            }
        };
    }

    /**
     * Getting product by code number
     * @param code code number
     * @return
     */
    @Override
    public Product getProduct(String code) {
        if(products.containsKey(code)) {
            return products.get(code);
        } else {
            return null;
        }
    }

}
