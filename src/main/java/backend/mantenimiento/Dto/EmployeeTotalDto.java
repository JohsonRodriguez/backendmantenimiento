package backend.mantenimiento.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeTotalDto {
    private Long id;
    private String name;
    private String lastname;
    private Double total;

    public EmployeeTotalDto(Long id, String name, String lastname, Double total) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.total = total;
    }
}

