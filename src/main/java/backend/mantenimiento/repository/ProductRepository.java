package backend.mantenimiento.repository;

import backend.mantenimiento.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProductRepository extends CrudRepository<Product,Long> {
    Product findByName(String name);

    @Modifying
    @Transactional
    @Query("update Product p set p.stock = :stock where p.id = :id")
    void  newStock (@Param(value = "stock")float stock,
                       @Param(value = "id")Long id);

}
