package backend.mantenimiento.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name ;
    private String unit;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Brand> brands = new ArrayList<>();

}
