package riwi.com.simulacrospringboot.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nombre;
    private String descripcion;

    @ManyToMany(mappedBy = "habilidad_id")
    private List<Mision> mision_id;

}
