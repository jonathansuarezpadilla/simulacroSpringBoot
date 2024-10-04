package riwi.com.simulacrospringboot.Controllers.ImpleControllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import riwi.com.simulacrospringboot.Controllers.InterfacesForEntity.InterfaceMissionControl;
import riwi.com.simulacrospringboot.Service.interfaces.IMissionService;
import riwi.com.simulacrospringboot.dtos.request.MisionRequest;
import riwi.com.simulacrospringboot.dtos.response.MissionResponse;
import riwi.com.simulacrospringboot.exception.ApiException;

@Controller
@RequestMapping("/mission")
@Tag(name="misiones")
public class MissionController implements InterfaceMissionControl {

    @Autowired
    IMissionService missionService;

    @Override
    @PostMapping
    @Operation(summary = "Este endpoint es para crear una mision", description="estes enpoint requiere que envies la informacion para poder crear una mision")
    @ApiResponse(responseCode = "400", //arreglar
            description = "Este error sale cuando falta un atributo o el tipo es invalido",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)
                    )
            })
    public ResponseEntity<String> create(@RequestBody MisionRequest request) {
        missionService.create(request);
        return ResponseEntity.ok("Mission created");
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Este endpoint es para buscar traer una habilidad", description="este enpoint requiere que envies el id de la habilidad")
    @ApiResponse(responseCode = "400", //arreglar
            description = "Este error sale cuando el id es invalido o la habilidad no existe",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)
                    )
            })
    public ResponseEntity<MissionResponse> ById(@PathVariable String id) {
        return ResponseEntity.ok(missionService.readById(id));
    }

}
