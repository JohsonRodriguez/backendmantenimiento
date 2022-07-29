package backend.mantenimiento.controller;

import backend.mantenimiento.Dto.ProductBrandDto;
import backend.mantenimiento.Dto.ProductNameDTO;
import backend.mantenimiento.entity.Product;
import backend.mantenimiento.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public Iterable<Product> getAllProducts(){
        return productService.listProduct();
    }

    @GetMapping("/allname")
    public ArrayList<ProductNameDTO> getAllProductsName(){
        return productService.ProductNamedList();
    }

    @GetMapping("/allbrand/{name}")
    public ArrayList<ProductBrandDto> getAllProductsBrand(@PathVariable("name") String name){
        return productService.ProductBrandList(name);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        productService.newProduct(product);
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

    @GetMapping("/count")
    public Long countProduct(){
        return productService.countProduct();
    }

    @GetMapping("findProduct/{name}")
    public Product getByProduct(@PathVariable("name") String name) {
        return productService.searchProduct(name);
    }
}
