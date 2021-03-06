package backend.mantenimiento.services;

import backend.mantenimiento.entity.Product;
import backend.mantenimiento.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> listProduct() {
        return productRepository.findAll();
    }

    @Override
    public void newProduct(Product product) {
     productRepository.save(product);
    }

    @Override
    public void updateStock(Float amount, Long id) {
           var product = (productRepository.findById(id)).get();
           var stock = product.getStock() + amount;
           productRepository.newStock(stock,product.getId());
    }

    @Override
    public void reduceStock(Float amount, Long id) {
        var product = (productRepository.findById(id)).get();
        var stock = product.getStock() - amount;
        productRepository.newStock(stock,product.getId());

    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Long countProduct() {
        return productRepository.count();
    }

    @Override
    public Product searchProduct(String name) {
        return productRepository.findByName(name);
    }
}
