package riwi.com.simulacrospringboot.dtos.response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import riwi.com.simulacrospringboot.utils.enumUsuario;

// quede siendo una clase como tal...

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserResponse {

    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private enumUsuario rol;//(enum)
}
