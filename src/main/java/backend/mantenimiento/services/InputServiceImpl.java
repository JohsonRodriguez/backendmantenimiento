package backend.mantenimiento.services;


import backend.mantenimiento.Dto.AllIput;
import backend.mantenimiento.Dto.InputDto;
import backend.mantenimiento.Dto.NewStockDto;
import backend.mantenimiento.Dto.ProductDto;
import backend.mantenimiento.entity.Input;
import backend.mantenimiento.entity.Product;
import backend.mantenimiento.entity.Stock;
import backend.mantenimiento.repository.InputRepository;
import backend.mantenimiento.repository.ProductRepository;
import backend.mantenimiento.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class InputServiceImpl implements InputService{

    private final InputRepository inputRepository;
    private final StockService  stockService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Autowired
    UsersRepository usersRepository;

    public InputServiceImpl(InputRepository inputRepository, StockService stockService) {
        this.inputRepository = inputRepository;
        this.stockService = stockService;
    }

    @Override
    public Iterable<Input> listInput() {
        return inputRepository.findAll();
    }


    @Override
    public void newInput(InputDto inputDto) {
      var day = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
      Input input = new Input();
      input.setDay(day);
      input.setAmount(inputDto.getAmount());
      input.setProduct(inputDto.getProduct());
      input.setBrand(inputDto.getBrand());
      input.setUsers(inputDto.getUsers());
        Stock stock = new Stock();
        stock.setProduct(inputDto.getProduct());
        stock.setBrand(inputDto.getBrand());
        stock.setStock(inputDto.getAmount());
      stockService.newStock(stock);
      inputRepository.save(input);
    }

    @Override
    public ArrayList<AllIput> getAllInput(String day) {
        return null;
    }

//    @Override
//    public ArrayList<AllIput> getAllInput(String day) {
//        ArrayList<AllIput> allInputs = inputRepository.totalInput(day);
//        return allInputs;
//    }
}
