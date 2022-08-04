package backend.mantenimiento.repository;

import backend.mantenimiento.Dto.AllIput;
import backend.mantenimiento.Dto.EmployeeTotalDto;
import backend.mantenimiento.entity.Input;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface InputRepository extends CrudRepository<Input,Long> {
//    @Query("SELECT new backend.mantenimiento.Dto.AllIput(i.amount,i.stock.product,i.stock.brand,i.users.name)  FROM Input as i WHERE i.day=:day")

//    ArrayList<AllIput> totalInput (@Param(value = "day")String day);

}
