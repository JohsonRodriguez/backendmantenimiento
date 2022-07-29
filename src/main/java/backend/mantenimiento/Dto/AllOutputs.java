package backend.mantenimiento.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllOutputs {
    private String productName;
    private String productBrand;
    private String locationName;
    private String userName;
    private String employeeName;
    private String employeeLastname;
    private Float amount;

    public AllOutputs(String productName, String productBrand, String locationName, String userName, String employeeName, String employeeLastname, Float amount) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.locationName = locationName;
        this.userName = userName;
        this.employeeName = employeeName;
        this.employeeLastname = employeeLastname;
        this.amount = amount;
    }
}
