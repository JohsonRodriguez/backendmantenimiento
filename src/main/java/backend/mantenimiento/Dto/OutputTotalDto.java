package backend.mantenimiento.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;


@Getter
@Setter
@AllArgsConstructor
public class OutputTotalDto {
   private String name;
    private Double total;
    private String unit;


}
