package backend.mantenimiento.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;


@Getter
@Setter

public class OutputTotalDto {
   private String name;
    private Double total;

    public OutputTotalDto( String name, Double total) {
        this.name = name;
        this.total = total;
    }
}
