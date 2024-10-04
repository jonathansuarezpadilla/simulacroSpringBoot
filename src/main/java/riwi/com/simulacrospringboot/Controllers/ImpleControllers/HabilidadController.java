package riwi.com.simulacrospringboot.Controllers.ImpleControllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import riwi.com.simulacrospringboot.Controllers.InterfacesForEntity.InterfaceHabilidadControl;
import riwi.com.simulacrospringboot.Service.interfaces.IHabilidadService;
import riwi.com.simulacrospringboot.dtos.request.HabilidadResquest;
import riwi.com.simulacrospringboot.dtos.response.HabilidadResponse;
import riwi.com.simulacrospringboot.exception.ApiException;

@Controller
@RequestMapping("/habilidad")
@Tag(name="Habilidades")
public class HabilidadController implements InterfaceHabilidadControl {


    @Autowired
    private IHabilidadService habilidadService;

    @Override
    @PostMapping
    @Operation(summary = "Este endpoint es para crear una habilidad", description="estes enpoint requiere que envies la informacion para poder crear una habilidad")
    @ApiResponse(responseCode = "400", //arreglar
            description = "Este error sale cuando falta un atributo o el tipo es invalido",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)
                    )
            })
    public ResponseEntity<String> create(@RequestBody @Valid HabilidadResquest request) {
        habilidadService.create(request);
        return ResponseEntity.ok().body("Skill successfully created");
    }


    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Este endpoint es para buscar traer una habilidad", description="estes enpoint requiere que envies el id de la habilidad")
    @ApiResponse(responseCode = "400", //arreglar
            description = "Este error sale cuando el id es invalido o la habilidad no existe",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)
                    )
            })
    public ResponseEntity<HabilidadResponse> readById(@PathVariable String id) {
        HabilidadResponse response = habilidadService.readById(id);
        return ResponseEntity.ok().body(response);
    }
}
