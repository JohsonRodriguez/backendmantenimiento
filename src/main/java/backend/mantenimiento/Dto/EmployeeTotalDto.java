package backend.mantenimiento.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeTotalDto {
    private String employee;
    private Double total;
    private String unit;


}

