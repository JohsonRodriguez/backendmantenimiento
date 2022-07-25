package backend.mantenimiento.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;


@Getter
@Setter

public class OutputTotalDto {
   private Long location;
    private Double total;

    public OutputTotalDto(Long location, Double total) {
        this.location = location;
        this.total = total;
    }
}
