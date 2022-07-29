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
    private Long users;
    private Long employee;
    private Long location;
}
