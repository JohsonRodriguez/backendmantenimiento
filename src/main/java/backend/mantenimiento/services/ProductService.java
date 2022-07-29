package backend.mantenimiento.services;

import backend.mantenimiento.entity.Product;

public interface ProductService {
    Iterable<Product> listProduct();
    Product newProduct(Product product);

    void updateProduct(Product product);
    Long countProduct();
    Product searchProduct(String name);
}
