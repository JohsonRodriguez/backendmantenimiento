package backend.mantenimiento.services;

import backend.mantenimiento.Dto.ProductBrandDto;
import backend.mantenimiento.Dto.ProductDto;
import backend.mantenimiento.Dto.ProductNameDTO;
import backend.mantenimiento.entity.Brand;
import backend.mantenimiento.entity.Product;
import backend.mantenimiento.entity.Stock;
import backend.mantenimiento.exception.NotFoundException;
import backend.mantenimiento.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private  final ProductRepository productRepository;
    private final BrandService brandService;
    private final StockService stockService;
    Brand Brand,checkBrand;
    Product product,checkProduct;
    public ProductServiceImpl(ProductRepository productRepository, BrandService brandService, StockService stockService) {
        this.productRepository = productRepository;
        this.brandService = brandService;
        this.stockService = stockService;
    }


    @Override
    public Iterable<Product> listProduct() {
        return productRepository.findAll();
    }

    @Override
    public void newProduct(ProductDto productDto) {

        getBrand(productDto.getBrandName());
        getProduct(productDto.getProductName(),productDto.getUnit());
            var allBrands = product.getBrands();
            for (Brand b : allBrands) {
              boolean check = b.getName().contains(checkBrand.getName());
               if (check) {
                throw new NotFoundException("Producto ya está registrado, ingrese otra marca");
               }
            }
        product.getBrands().add(checkBrand);
        Stock stock = new Stock();
        stock.setProduct(product.getName());
        stock.setBrand(checkBrand.getName());
        stock.setStock(0);
        stockService.newStock(stock);

    }

    private void getProduct(String name,String unit) {
        var checkProduct = productRepository.findByName(name);
        if (checkProduct == null) {
            Product newProduct = new Product();
            newProduct.setName(name);
            newProduct.setUnit(unit);
            try {
                product = productRepository.save(newProduct);
            } catch (Exception e) {
                throw new NotFoundException(e.getMessage());
            }
        }else{
            product=checkProduct;
        }

    }

    private void getBrand(String name) {
         checkBrand = brandService.searchBrand(name);
        if (checkBrand == null) {
            try {
                checkBrand = brandService.newBrand(name);
            } catch (Exception e) {
                throw new NotFoundException(e.getMessage());
            }
        }else{
            checkBrand = brandService.searchBrand(name);
        }
    }

    @Override
    public ArrayList<ProductNameDTO> ProductNamedList() {
        return productRepository.getProductName();
    }

    @Override
    public ArrayList<ProductBrandDto> ProductBrandList(String productName) {
        return productRepository.getProductBrand(productName);
    }

//    @Override
//    public void updateStock(Float amount, Long id) {
//           var product = (productRepository.findById(id)).get();
//           var stock = product.getStock() + amount;
//           productRepository.newStock(stock,product.getId());
//    }

//    @Override
//    public void reduceStock(Float amount, Long id) {
//        var product = (productRepository.findById(id)).get();
//        var stock = product.getStock() - amount;
//        productRepository.newStock(stock,product.getId());
//
//    }

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
