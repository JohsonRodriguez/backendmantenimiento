package backend.mantenimiento.controller;


import backend.mantenimiento.Dto.*;
import backend.mantenimiento.entity.Output;
import backend.mantenimiento.services.OutputService;
import org.hibernate.mapping.Array;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

//    @GetMapping("/sum/{idlocation}/{idproduct}/{date}")
//    public float getSumAmount(@PathVariable Long idlocation,@PathVariable Long idproduct,@PathVariable String date){
//      return   outputService.getTotalAmount(idlocation,idproduct,date);
//    }
    @PostMapping("/sum")
    public ArrayList<OutputTotalDto> getSumAmount(@RequestBody OutputCountDto outputCountDto){
        return   outputService.getTotalAmount(outputCountDto);
    }

    @PostMapping("/sumemployee")
    public ArrayList<EmployeeTotalDto> getSumAmountEmployee(@RequestBody OutputCountDto outputCountDto){
        return   outputService.getTotalAmountEmployee(outputCountDto);
    }

    @PostMapping("/allbyday/{day}")
    public ArrayList<AllOutputs> getAllOutputsbyDay(@PathVariable String day){
        return   outputService.getAllOutputs(day);
    }

}
