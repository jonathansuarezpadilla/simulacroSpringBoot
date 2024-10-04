package riwi.com.simulacrospringboot.dtos.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import riwi.com.simulacrospringboot.utils.enumCompletada;
import riwi.com.simulacrospringboot.utils.enumNivel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MisionRequest {

    //realizar validaciones
    @NotBlank(message = "Se requiere titulo")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El titulo solo puede contener letras")
    private String titulo;

    @NotBlank(message = "Se requiere descripción")
    @Pattern(regexp = "^[a-zA-Z\\s.,;:!?()]+$", message = "La descripcion solo puede contener letras y signos de puntuación")
    private String descripcion;

    //private String imagen;


    @Pattern(regexp = "^[a-zA-Z]+$", message = "El titulo solo puede contener letras")
    @NotBlank(message = "El nivel es requerido")
    private enumNivel nivel; // enum

    @NotBlank(message = "Se requiere asignación de puntos")
    @Pattern(regexp = "^[0-9]+$", message = "El campo solo puede contener números")
    private int puntos;


    @Pattern(regexp = "^[a-zA-Z]+$", message = "El titulo solo puede contener letras")
    @NotBlank(message = "Se requiere estado de completación de la misión")
    private enumCompletada completada;

}
