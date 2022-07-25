package backend.mantenimiento.repository;

import backend.mantenimiento.Dto.OutputTotalDto;

import backend.mantenimiento.entity.Output;
import org.hibernate.mapping.Array;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface OutputRepository extends CrudRepository<Output,Long> {
    //@Modifying
    //@Transactional
    // @Query("SELECT o.location.id, SUM(o.amount) as total  FROM Output o WHERE o.product.id=:product AND o.day LIKE :date% group by o.location.id order by total desc")
    @Query("SELECT new backend.mantenimiento.Dto.OutputTotalDto(o.location.name,SUM(o.amount))  FROM Output as o WHERE o.product.id=:product AND o.day LIKE :date% group by o.location.name")
    ArrayList<OutputTotalDto> totalAmount (@Param(value = "product")Long idproduct,
                                           @Param(value = "date")String date);

}
