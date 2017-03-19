package application.service;

import application.dao.ProductDao;
import application.dao.ProductDaoImpl;
import application.entity.Product;

/**
 * PointOfSale
 * Created by Grzegorz Kossowski on 18.03.17.
 */
public class ProductServiceImpl implements ProductService {

    /**
     * Product Data Acess Object
     */
    private ProductDao productDao = new ProductDaoImpl();

    /**
     * Getting product by codenumber
     * @param code code nubmer
     * @return
     */
    @Override
    public Product getProduct(String code) {
        return productDao.getProduct(code);
    }
}
