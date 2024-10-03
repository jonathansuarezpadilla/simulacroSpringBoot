package riwi.com.simulacrospringboot.dtos.response;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class HabilidadResponse {

    private String id;
    private String nombre;
    private String descripcion;

}
