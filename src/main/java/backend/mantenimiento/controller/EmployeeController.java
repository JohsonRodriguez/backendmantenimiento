package backend.mantenimiento.controller;


import backend.mantenimiento.entity.Employee;
import backend.mantenimiento.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/all")
    public Iterable<Employee> getAllEmployee(){
        return employeeService.listEmployee();
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.newEmployee(employee);
    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @GetMapping("/count")
    public Long countEmployee(){
        return employeeService.countEmployee();
    }

    @GetMapping("findEmployee/{name}")
    public Employee getByEmployee(@PathVariable("name") String name) {
        return employeeService.searchEmployee(name);
    }
}
