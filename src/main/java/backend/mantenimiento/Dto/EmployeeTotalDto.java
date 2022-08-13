package backend.mantenimiento.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeTotalDto {
    private String employee;
    private Double total;

    public EmployeeTotalDto(String employee, Double total) {
        this.employee = employee;
        this.total = total;
    }
}

