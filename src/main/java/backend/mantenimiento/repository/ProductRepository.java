package backend.mantenimiento.repository;

import backend.mantenimiento.Dto.ProductBrandDto;
import backend.mantenimiento.Dto.ProductNameDTO;
import backend.mantenimiento.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {
    Product findByName(String name);
    Product findByNameAndBrand(String name, String brand);

       @Query("select new backend.mantenimiento.Dto.ProductNameDTO(p.name,p.unit) from Product p group by p.name,p.unit")
       ArrayList<ProductNameDTO> getProductName ();

    @Query("select new backend.mantenimiento.Dto.ProductBrandDto(p.brand) from Product p where p.name= :name")
    ArrayList<ProductBrandDto> getProductBrand (@Param(value = "name")String name);


//    @Modifying
//    @Transactional
//    @Query("update Product p set p.stock = :stock where p.id = :id")
//    void  newStock (@Param(value = "stock")float stock,
//                       @Param(value = "id")Long id);

}
