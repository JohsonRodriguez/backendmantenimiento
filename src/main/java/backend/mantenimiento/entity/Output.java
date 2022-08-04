package backend.mantenimiento.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Output {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String day;
    private float amount;
    private String users;
    private String location;
    private String employee;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "users_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private Users users;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "stock_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private Stock stock;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "location_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private Location location;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "employee_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private Employee employee;
}
