package riwi.com.simulacrospringboot.dtos.request;

import jakarta.validation.constraints.*;
import lombok.*;
import riwi.com.simulacrospringboot.dtos.request.Validation.FullValidationGroup;
import riwi.com.simulacrospringboot.utils.enumUsuario;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserRequest {

    @NotBlank(groups = FullValidationGroup.class,message = "nombre es requerido")
    private String nombre;
    @NotBlank(groups = FullValidationGroup.class,message = "apellido es requerido")
    private String apellido;

    @NotBlank(groups = FullValidationGroup.class,message = "El correo es requerido")
    @Email(message = "Introduzca un correo electronico valido")
    private String email;

    @NotNull(groups = FullValidationGroup.class,message = "El rol es obligatorio")
    private enumUsuario rol;


    @NotBlank(groups = FullValidationGroup.class,message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
            message = "La contraseña debe contener al menos un dígito, una letra minúscula, una letra mayúscula y un carácter especial")
    private String password;

}
