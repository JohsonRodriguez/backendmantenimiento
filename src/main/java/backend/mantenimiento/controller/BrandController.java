package backend.mantenimiento.controller;

import backend.mantenimiento.entity.Brand;
import backend.mantenimiento.entity.Employee;
import backend.mantenimiento.services.BrandService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }


    @GetMapping("/all")
    public Iterable<Brand> getAllBrand(){
        return brandService.getAllBrand();
    }
}
