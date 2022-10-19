package Sever;

import Form.Product;

import java.util.ArrayList;

public interface IProductServices {
    ArrayList<Product> getProducts();

    void add(Product newProduct);


    Product getProductById(long id);

    boolean existProductById(long id);


    void removeById(long id);
}
