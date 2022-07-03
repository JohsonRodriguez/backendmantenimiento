package backend.mantenimiento.services;


import backend.mantenimiento.entity.Employee;

public interface EmployeeService {
    Iterable<Employee> listEmployee();
    void newEmployee(Employee employee);
    void updateEmployee(Employee employee);
    Long countEmployee();
    Employee searchEmployee(String name);
}
