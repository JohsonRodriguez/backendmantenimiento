package backend.mantenimiento.services;

import backend.mantenimiento.Dto.*;
import backend.mantenimiento.entity.Output;
import backend.mantenimiento.entity.Stock;
import backend.mantenimiento.exception.NotFoundException;
import backend.mantenimiento.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OutputServiceImpl implements OutputService{

    private final OutputRepository outputRepository;
    private final StockService stockService;

    public OutputServiceImpl(OutputRepository outputRepository, StockService stockService) {
        this.outputRepository = outputRepository;
        this.stockService = stockService;
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
        try{
            var day = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            var output = new Output();
            output.setAmount(outputDto.getAmount());
            output.setDay(day);
            output.setUsers(outputDto.getUsers());
            output.setLocation(outputDto.getLocation());
            output.setEmployee(outputDto.getEmployee());
            output.setProduct(outputDto.getProductName());
            output.setBrand(outputDto.getProductBrand());
            output.setUnit(outputDto.getUnit());
            Stock stock = new Stock();
            stock.setProduct(outputDto.getProductName());
            stock.setBrand(outputDto.getProductBrand());
            stock.setStock(outputDto.getAmount());
            stockService.reduceStock(stock);

            outputRepository.save(output);
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }


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

//        return outputRepository.totalAmount(outputCountDto.getProduct(),outputCountDto.getDate());
        return arrayList;

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
    public ArrayList<Output> getAllOutputs(String day) {
        return outputRepository.OutputsbyDay(day);

    }
}
