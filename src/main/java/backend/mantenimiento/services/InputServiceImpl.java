package backend.mantenimiento.services;


import backend.mantenimiento.Dto.AllIput;
import backend.mantenimiento.Dto.InputDto;
import backend.mantenimiento.entity.Input;
import backend.mantenimiento.entity.Product;
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

    public InputServiceImpl(InputRepository inputRepository) {
        this.inputRepository = inputRepository;
    }
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Autowired
    UsersRepository usersRepository;
    @Override
    public Iterable<Input> listInput() {
        return inputRepository.findAll();
    }


    @Override
    public void newInput(InputDto inputDto) {
      var users  =(usersRepository.findById(inputDto.getUsers())).get();
      var product=(productRepository.findById(inputDto.getProduct())).get();
      var day = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
      var amount=inputDto.getAmount();
      productService.updateStock(amount,product.getId());
      var input = new Input();
      input.setDay(day);
      input.setAmount(amount);
      input.setProduct(product);
      input.setUsers(users);
      inputRepository.save(input);
    }

    @Override
    public void updateInput(Input input) {
        inputRepository.save(input);
    }

    @Override
    public ArrayList<AllIput> getAllInput(String day) {
        ArrayList<AllIput> allInputs = inputRepository.totalInput(day);
        return allInputs;
    }
}
