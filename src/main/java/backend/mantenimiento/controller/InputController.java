package backend.mantenimiento.controller;


import backend.mantenimiento.Dto.AllIput;
import backend.mantenimiento.Dto.InputDto;
import backend.mantenimiento.entity.Input;
import backend.mantenimiento.services.InputService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("/input")
public class InputController {
    private final InputService inputService;

    public InputController(InputService inputService) {
        this.inputService = inputService;
    }

    @GetMapping("/all")
    public Iterable<Input> getAllInput(){
        return inputService.listInput();
    }

    @PostMapping("/add")
    public void addInput(@RequestBody InputDto inputDto){
        inputService.newInput(inputDto);
    }

    @PostMapping("/getall/{day}")
    public ArrayList<AllIput> getAllInputs(@PathVariable String day) {
       return inputService.getAllInput(day);
    }


   }
