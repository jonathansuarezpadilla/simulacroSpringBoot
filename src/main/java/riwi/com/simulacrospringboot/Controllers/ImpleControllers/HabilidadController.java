package riwi.com.simulacrospringboot.Controllers.ImpleControllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import riwi.com.simulacrospringboot.Controllers.InterfacesForEntity.InterfaceHabilidadControl;
import riwi.com.simulacrospringboot.Service.interfaces.IHabilidadService;
import riwi.com.simulacrospringboot.dtos.request.HabilidadResquest;
import riwi.com.simulacrospringboot.dtos.response.HabilidadResponse;

@Controller
@RequestMapping("/habilidad")
public class HabilidadController implements InterfaceHabilidadControl {


    @Autowired
    private IHabilidadService habilidadService;

    @Override
    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid HabilidadResquest request) {
        habilidadService.create(request);
        return ResponseEntity.ok().body("Skill successfully created");
    }


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<HabilidadResponse> readById(@PathVariable String id) {
        HabilidadResponse response = habilidadService.readById(id);
        return ResponseEntity.ok().body(response);
    }
}
