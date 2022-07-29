package backend.mantenimiento.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class NewStockDto {
    private String productName;
    private String productBrand;
    private Float amount;

    public NewStockDto() {

    }
}
