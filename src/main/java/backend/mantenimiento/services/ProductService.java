package backend.mantenimiento.services;

import backend.mantenimiento.entity.Product;

public interface ProductService {
    Iterable<Product> listProduct();
    void newProduct(Product product);
    void updateStock(Product product);
    void updateProduct(Product product);
    Long countProduct();
    Product searchProduct(String name);
}
