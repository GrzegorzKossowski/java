package application.dao;

import application.entity.Product;

/**
 * PointOfSale
 * Created by Grzegorz Kossowski on 18.03.17.
 */
public interface ProductDao {

    public Product getProduct(String code);

}
