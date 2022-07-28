package backend.mantenimiento.services;

import backend.mantenimiento.Dto.*;
import backend.mantenimiento.entity.Output;
import backend.mantenimiento.repository.*;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OutputServiceImpl implements OutputService{

    private final OutputRepository outputRepository;

    public OutputServiceImpl(OutputRepository outputRepository) {
        this.outputRepository = outputRepository;
    }

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProductService productService;

    @Override
    public Iterable<Output> listOutput() {
        return outputRepository.findAll();
    }

    @Override
    public void newOutput(OutputDto outputDto) {
        var users  =(usersRepository.findById(outputDto.getUsers())).get();
        var product=(productRepository.findById(outputDto.getProduct())).get();
        var location = (locationRepository.findById(outputDto.getLocation())).get();
        var employee= (employeeRepository.findById(outputDto.getEmployee())).get();
        var day = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        var amount=outputDto.getAmount();
        productService.reduceStock(amount,product.getId());
        var output = new Output();
        output.setDay(day);
        output.setAmount(amount);
        output.setProduct(product);
        output.setUsers(users);
        output.setLocation(location);
        output.setEmployee(employee);
        outputRepository.save(output);

    }

    @Override
    public ArrayList<OutputTotalDto> getTotalAmount(OutputCountDto outputCountDto) {
       ArrayList arrayList = outputRepository.totalAmount(outputCountDto.getProduct(),outputCountDto.getDate());
        Collections.sort(arrayList, new Comparator<OutputTotalDto>() {

            @Override
            public int compare(OutputTotalDto o1, OutputTotalDto o2) {
                return (o2.getTotal()).compareTo((o1.getTotal()));
            }
        });
        return arrayList;
//        return outputRepository.totalAmount(outputCountDto.getProduct(),outputCountDto.getDate());
    }

    @Override
    public ArrayList<EmployeeTotalDto> getTotalAmountEmployee(OutputCountDto outputCountDto) {
        ArrayList arrayListEmployee = outputRepository.totalAmountEmployee(outputCountDto.getProduct(),outputCountDto.getDate());
        Collections.sort(arrayListEmployee, new Comparator<EmployeeTotalDto>() {

            @Override
            public int compare(EmployeeTotalDto e1, EmployeeTotalDto e2) {
                return (e2.getTotal()).compareTo((e1.getTotal()));
            }
        });
        return  arrayListEmployee;
    }

    @Override
    public ArrayList<AllOutputs> getAllOutputs(String day) {
        ArrayList<AllOutputs> allOutputsList = outputRepository.OutputsbyDay(day);
        return allOutputsList;
    }
}
