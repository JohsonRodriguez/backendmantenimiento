package backend.mantenimiento.services;

import backend.mantenimiento.Dto.OutputCountDto;
import backend.mantenimiento.Dto.OutputDto;
import backend.mantenimiento.Dto.OutputTotalDto;
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
}
