package riwi.com.simulacrospringboot.dtos.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HabilidadResquest {

    @NotBlank(message = "Campo requerido")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El nombre solo puede contener letras")
    private String nombre;

    @NotBlank(message = "campo requerido")
    @Pattern(regexp = "^[a-zA-Z\\s.,;:!?()]+$", message = "La descripcion solo puede contener letras y signos de puntuación")
    private String descripcion;

}
