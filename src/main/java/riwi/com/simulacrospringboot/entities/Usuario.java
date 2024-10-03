package riwi.com.simulacrospringboot.entities;


import jakarta.persistence.*;
import lombok.*;
import riwi.com.simulacrospringboot.utils.enumUsuario;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    @Enumerated(EnumType.STRING)
    private enumUsuario rol;//(enum)
    private String password;

    @ManyToMany(mappedBy = "usuario_id")
    private List<Mision> mision_id;

    @ManyToMany
    @JoinTable(
            name="usuario_habilidad",
            joinColumns=@JoinColumn(name="usuarios_id"),
            inverseJoinColumns = @JoinColumn(name="habilidades_id")
    )
    private List<Habilidad> habilidades;

}
