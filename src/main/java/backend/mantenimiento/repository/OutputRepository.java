package backend.mantenimiento.repository;

import backend.mantenimiento.entity.Output;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface OutputRepository extends CrudRepository<Output,Long> {
    //@Modifying
    //@Transactional
    @Query("SELECT SUM(o.amount) FROM Output o WHERE o.location.id=:location AND o.product.id=:product AND o.day LIKE :date%")
    float  totalAmount (@Param(value = "location")Long idlocation,
                    @Param(value = "product")Long idproduct,
                        @Param(value = "date")String date);

}
