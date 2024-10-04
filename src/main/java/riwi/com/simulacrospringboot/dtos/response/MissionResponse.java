package riwi.com.simulacrospringboot.dtos.response;


import lombok.*;
import riwi.com.simulacrospringboot.utils.enumCompletada;
import riwi.com.simulacrospringboot.utils.enumNivel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MissionResponse {
    private String id;
    private String titulo;
    private String descripcion;
    //private String imagen;
    private enumNivel nivel; // enum
    private int puntos;
    private enumCompletada completada;
}
