package backend.mantenimiento.controller;


import backend.mantenimiento.Dto.InputDto;
import backend.mantenimiento.entity.Input;
import backend.mantenimiento.services.InputService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update")
    public void updateInput(@RequestBody Input input){
        inputService.updateInput(input);
    }

   }
