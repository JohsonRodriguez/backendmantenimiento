package backend.mantenimiento.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OutputDto {
    private float amount;
    private String productName;
    private String productBrand;
    private String users;
    private String employee;
    private String location;
    private String unit;
}
