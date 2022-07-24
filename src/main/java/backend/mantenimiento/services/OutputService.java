package backend.mantenimiento.services;


import backend.mantenimiento.Dto.OutputCountDto;
import backend.mantenimiento.Dto.OutputDto;
import backend.mantenimiento.entity.Output;

public interface OutputService {
    Iterable<Output> listOutput();
    void newOutput(OutputDto outputDto);
    float  getTotalAmount(OutputCountDto outputCountDto);
}
