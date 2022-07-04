package backend.mantenimiento.services;


import backend.mantenimiento.Dto.InputDto;
import backend.mantenimiento.entity.Input;

public interface InputService {
    Iterable<Input> listInput();
    void newInput(InputDto inputDto);
    void updateInput(Input input);

}
