package backend.mantenimiento.services;

import backend.mantenimiento.entity.Brand;
import backend.mantenimiento.repository.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService{
    private final BrandRepository  brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand newBrand(String name) {
        Brand brand = new Brand();
        brand.setName(name);
       return brandRepository.save(brand);
    }

    @Override
    public Brand searchBrand(String name) {
        return brandRepository.findByName(name);
    }

    @Override
    public Iterable<Brand> getAllBrand() {
        return brandRepository.findAll();
    }
}
