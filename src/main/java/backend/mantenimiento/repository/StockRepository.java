package backend.mantenimiento.repository;

import backend.mantenimiento.entity.Product;
import backend.mantenimiento.entity.Stock;
import org.springframework.data.repository.CrudRepository;



public interface StockRepository extends CrudRepository<Stock, Long> {
    Stock findByProduct(Product product);

}
