package riwi.com.simulacrospringboot.Controllers.ImpleControllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import riwi.com.simulacrospringboot.Controllers.InterfacesForEntity.InterfaceAssingControll;
import riwi.com.simulacrospringboot.Service.interfaces.IMissionService;
import riwi.com.simulacrospringboot.Service.interfaces.IUsuarioService;
import riwi.com.simulacrospringboot.exception.ApiException;

import java.util.List;

@Controller
@RequestMapping("Api/v1")
@Tag(name="Asignación")
public class AssingController implements InterfaceAssingControll {

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    IMissionService missionService;

    @Override
    @PostMapping("/estudiantes/{id}/misiones")
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @Operation(summary = "Este endpoint es para asignar misiones a estudiantes", description="Este enpoint requiere que envies una lista de Ids que corresponde al de cada misión, tambien que ingreses el id del estudiante en la solicitud")
    @ApiResponse(responseCode = "400", //arreglar
            description = "Este error sale cuando falta un atributo o el tipo es invalido",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)
                    )
            })
    public ResponseEntity<String> assingMision(@PathVariable String id,@RequestBody List<String> MisssionIds) {
        usuarioService.assingMission(id, MisssionIds);
        return ResponseEntity.ok().body("Mision Assing");
    }

    @Override
    @PostMapping("/estudiantes/{id}/habilidades")
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @Operation(summary = "Este endpoint es para asignar habilidades a estudiantes", description="Este enpoint requiere que envies una lista de Ids que corresponden al de cada habilidad, tambien que mandes el id del estudiante en la solicitud")
    @ApiResponse(responseCode = "400", //arreglar
            description = "Este error sale cuando falta un atributo o el tipo es invalido",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)
                    )
            })
    public ResponseEntity<String> assign(@PathVariable String id, @RequestBody List<String> habilidadesIds) {
        usuarioService.assingAbility(id,habilidadesIds);
        return ResponseEntity.ok("User successfully assigned to habilidades");
    }

    @Override
    @PostMapping("/mision/{id}/habilidades")
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @Operation(summary = "Este endpoint es para asignar habilidades a las misiones", description="Este enpoint requiere que envies una lista de Ids que corresponden al de cada habilidad, tambien que mandes el id de la mision en la solicitud")
    @ApiResponse(responseCode = "400", //arreglar
            description = "Este error sale cuando falta un atributo o el tipo es invalido",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)
                    )
            })
    public ResponseEntity<String> assignHabilityMission(@PathVariable String id, @RequestBody List<String> habilidadesIds) {
        missionService.assingAbility(id,habilidadesIds);
        return ResponseEntity.ok("User successfully assigned to Mission");
    }


}
