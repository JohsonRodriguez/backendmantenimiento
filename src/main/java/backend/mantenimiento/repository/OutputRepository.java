package backend.mantenimiento.repository;

import backend.mantenimiento.Dto.AllOutputs;
import backend.mantenimiento.Dto.EmployeeTotalDto;
import backend.mantenimiento.Dto.OutputTotalDto;

import backend.mantenimiento.entity.Input;
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
    @Query("SELECT new backend.mantenimiento.Dto.OutputTotalDto(o.location,SUM(o.amount),o.unit)  FROM Output as o WHERE o.product=:product AND o.day LIKE :date% group by o.location")
    ArrayList<OutputTotalDto> totalAmount (@Param(value = "product")String product,
                                           @Param(value = "date")String date);
//
    @Query("SELECT new backend.mantenimiento.Dto.EmployeeTotalDto(o.employee,SUM(o.amount),o.unit)  FROM Output as o WHERE o.product=:product AND o.day LIKE :date% group by o.employee")
    ArrayList<EmployeeTotalDto> totalAmountEmployee (@Param(value = "product")String product,
                                                     @Param(value = "date")String date);
//


    @Query("SELECT o FROM Output o WHERE o.day=:day")
    ArrayList<Output> OutputsbyDay (@Param(value = "day")String day);

}
