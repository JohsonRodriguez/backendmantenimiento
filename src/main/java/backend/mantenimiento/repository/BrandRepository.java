package backend.mantenimiento.repository;

import backend.mantenimiento.entity.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand,Long>{
    Brand findByName(String name);
}
