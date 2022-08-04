package backend.mantenimiento.services;

import backend.mantenimiento.entity.Brand;

public interface BrandService {
    Brand newBrand(String name);
    Brand searchBrand(String name);
    Iterable<Brand> getAllBrand();
}
