package riwi.com.simulacrospringboot.entities;


import jakarta.persistence.*;
import lombok.*;
import riwi.com.simulacrospringboot.utils.enumCompletada;
import riwi.com.simulacrospringboot.utils.enumNivel;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mision {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String titulo;
    private String descripcion;
    //private String imagen;
    private enumNivel nivel; // enum
    private int puntos;
    private enumCompletada completada;

    @ManyToMany
    @JoinTable(
            name="usuario_mision",
            joinColumns=@JoinColumn(name="mision_id"),
            inverseJoinColumns = @JoinColumn(name="usuario_id")
    )
    private List<Usuario> usuario_id;

    @ManyToMany
    @JoinTable(
            name="habilidad_mision",
            joinColumns = @JoinColumn(name="mision_id"),
            inverseJoinColumns = @JoinColumn(name="habilidad_id")
    )
    private List<Habilidad> habilidad_id;


}
