package backend.mantenimiento.services;


import backend.mantenimiento.Dto.*;
import backend.mantenimiento.entity.Output;
import org.hibernate.mapping.Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface OutputService {
    Iterable<Output> listOutput();
    void newOutput(OutputDto outputDto);
    ArrayList<OutputTotalDto> getTotalAmount(OutputCountDto outputCountDto);
    ArrayList<EmployeeTotalDto> getTotalAmountEmployee(OutputCountDto outputCountDto);
    ArrayList<AllOutputs>getAllOutputs(String day);
}
