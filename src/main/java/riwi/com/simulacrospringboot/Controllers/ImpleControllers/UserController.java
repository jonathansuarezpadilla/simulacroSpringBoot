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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import riwi.com.simulacrospringboot.Controllers.InterfacesForEntity.InterfaceUserControl;
import riwi.com.simulacrospringboot.Service.interfaces.IUsuarioService;
import riwi.com.simulacrospringboot.dtos.request.UserRequest;
import riwi.com.simulacrospringboot.dtos.request.Validation.FullValidationGroup;
import riwi.com.simulacrospringboot.dtos.response.UserResponse;
import riwi.com.simulacrospringboot.exception.ApiException;

import java.util.List;



@Controller
@RequestMapping("usuario")
@Tag(name="Usuario")
public class UserController implements InterfaceUserControl {

    @Autowired
    IUsuarioService usuarioService;

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Este endpoint es para traer un usuario", description="estes enpoint requiere que envies el id del usuario")
    @ApiResponse(responseCode = "400", //arreglar
            description = "Este error sale cuando el id es invalido o el usuario no existe",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)
                    )
            })
    public ResponseEntity<UserResponse> ById(@PathVariable String id) {
        UserResponse response =usuarioService.readById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping
    @Operation(summary = "Este endpoint es para buscar crear un usuario", description="este enpoint requiere que envies el la informacion para poder crear un usuario")
    @ApiResponse(responseCode = "400", //arreglar
            description = "Este error sale cuando falta un atributo o el tipo es invalido",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)
                    )
            })
    public ResponseEntity<String> create(@RequestBody @Valid UserRequest entity) {
        usuarioService.create(entity);
        return ResponseEntity.ok("User successfully created");
    }

    @Override
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Este endpoint es para eliminar un usuario", description="estes enpoint requiere que envies el id del usuario")
    @ApiResponse(responseCode = "400", //arreglar
            description = "Este error sale cuando el id es invalido o el usuario no existe",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)
                    )
            })
    public ResponseEntity<String> delete(@PathVariable String id) {
        usuarioService.delete(id);
        return ResponseEntity.ok("User successfully deleted");
    }

    @Override
    @GetMapping("/readAll")
    @Operation(summary = "Este endpoint es para traer todos los usuario que existen", description="este endpoint no requiere nada")
    @ApiResponse(responseCode = "400", //arreglar
            description = "Este error sale cuando el id es invalido o el usuario no existe",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)
                    )
            })
    public ResponseEntity<List<UserResponse>> readAll() {
        return  ResponseEntity.ok(usuarioService.readAll());
    }

    @Override
    @PutMapping("/update/{id}")
    @Operation(summary = "Este endpoint es para actualizar completamente un usuario", description="estes enpoint requiere que envies el id del usuario y la informacion completa que necesita un usuario")
    @ApiResponse(responseCode = "400", //arreglar
            description = "Este error sale cuando el id es invalido o el usuario no existe",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)
                    )
            })
    public ResponseEntity<String> put(@RequestBody @Validated(FullValidationGroup.class) UserRequest entity, @PathVariable String id) {
        usuarioService.update(entity, id);
        return ResponseEntity.ok("User successfully updated");
    }


    @Override
    @PatchMapping("/path/{id}")
    @Operation(summary = "Este endpoint es para actualizar un dato del usuario", description="estos enpoint requiere que envies el id del usuario y la información especifica a actualizar ")
    @ApiResponse(responseCode = "400", //arreglar
            description = "Este error sale cuando el id es invalido o el usuario no existe",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)
                    )
            })
    public ResponseEntity<String> path(@RequestBody  @Valid UserRequest request,@PathVariable String id) {
        usuarioService.path(request,id);
        return ResponseEntity.ok("User successfully updated");
    }


}
