package backend.mantenimiento.services;


import backend.mantenimiento.Dto.AllIput;
import backend.mantenimiento.Dto.InputDto;
import backend.mantenimiento.entity.Input;

import java.util.ArrayList;

public interface InputService {
    Iterable<Input> listInput();
    void newInput(InputDto inputDto);
    ArrayList<Input> getAllInput(String day);

}
