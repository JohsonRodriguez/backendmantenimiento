package backend.mantenimiento.services;

import backend.mantenimiento.entity.Employee;
import backend.mantenimiento.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> listEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void newEmployee(Employee employee) {
     employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Long countEmployee() {
        return employeeRepository.count();
    }

    @Override
    public Employee searchEmployee(String name) {
        return employeeRepository.searchByName(name);
    }
}
