package backend.mantenimiento.services;


import backend.mantenimiento.Dto.OutputCountDto;
import backend.mantenimiento.Dto.OutputDto;
import backend.mantenimiento.Dto.OutputTotalDto;
import backend.mantenimiento.entity.Output;
import org.hibernate.mapping.Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface OutputService {
    Iterable<Output> listOutput();
    void newOutput(OutputDto outputDto);
    ArrayList<OutputTotalDto> getTotalAmount(OutputCountDto outputCountDto);
}
