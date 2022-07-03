package backend.mantenimiento.repository;

import backend.mantenimiento.entity.Employee;
import org.springframework.data.repository.CrudRepository;



public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    Employee searchByName(String name);
}
