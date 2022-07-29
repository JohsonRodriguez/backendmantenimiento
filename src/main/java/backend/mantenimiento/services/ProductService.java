package backend.mantenimiento.services;

import backend.mantenimiento.Dto.ProductBrandDto;
import backend.mantenimiento.Dto.ProductNameDTO;
import backend.mantenimiento.entity.Product;

import java.util.ArrayList;

public interface ProductService {
    Iterable<Product> listProduct();
    Product newProduct(Product product);
    ArrayList<ProductNameDTO> ProductNamedList();
    ArrayList<ProductBrandDto> ProductBrandList(String productName);
    void updateProduct(Product product);
    Long countProduct();
    Product searchProduct(String name);
}
