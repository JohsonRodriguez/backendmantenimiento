package backend.mantenimiento.controller;


import backend.mantenimiento.Dto.OutputDto;
import backend.mantenimiento.entity.Output;
import backend.mantenimiento.services.OutputService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/output")
public class OutputController {

    private final OutputService outputService;

    public OutputController(OutputService outputService) {
        this.outputService = outputService;
    }


    @GetMapping("/all")
    public Iterable<Output> getAllOutputs(){
        return outputService.listOutput();

    }

    @PostMapping("/add")
    public void addOutput(@RequestBody OutputDto outputDto){
        outputService.newOutput(outputDto);
    }

}
