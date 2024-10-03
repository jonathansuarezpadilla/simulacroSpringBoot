package riwi.com.simulacrospringboot.Controllers.ImpleControllers;

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

import java.util.List;



@Controller
@RequestMapping("/api/v1")
public class UserController implements InterfaceUserControl {

    @Autowired
    IUsuarioService usuarioService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> ById(@PathVariable String id) {
        UserResponse response =usuarioService.readById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid UserRequest entity) {
        usuarioService.create(entity);
        return ResponseEntity.ok("User successfully created");
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        usuarioService.delete(id);
        return ResponseEntity.ok("User successfully deleted");
    }

    @Override
    @GetMapping("/readAll")
    public ResponseEntity<List<UserResponse>> readAll() {
        return  ResponseEntity.ok(usuarioService.readAll());
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<String> put(@RequestBody @Validated(FullValidationGroup.class) UserRequest entity, @PathVariable String id) {
        usuarioService.update(entity, id);
        return ResponseEntity.ok("User successfully updated");
    }


    @Override
    @PatchMapping("/path/{id}")
    public ResponseEntity<String> path(@RequestBody  @Valid UserRequest request,@PathVariable String id) {
        usuarioService.path(request,id);
        return ResponseEntity.ok("User successfully updated");
    }

    @Override
    @PostMapping("/estudiantes/{id}/habilidades")
    public ResponseEntity<String> assign(@PathVariable String id,@RequestBody List<String> habilidadesIds) {
        usuarioService.assingAbility(id,habilidadesIds);
        return ResponseEntity.ok("User successfully assigned to habilidades");
    }
}
