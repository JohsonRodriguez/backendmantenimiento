package backend.mantenimiento.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AllIput {
    private Float amount;
    private String productName;
    private String brandName;
    private String userName;

    public AllIput(Float amount, String productName, String brandName, String userName) {
        this.amount = amount;
        this.productName = productName;
        this.brandName = brandName;
        this.userName = userName;
    }
}
