package riwi.com.simulacrospringboot.Controllers.ImpleControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import riwi.com.simulacrospringboot.Controllers.InterfacesForEntity.InterfaceAssingControll;
import riwi.com.simulacrospringboot.Service.interfaces.IMissionService;
import riwi.com.simulacrospringboot.Service.interfaces.IUsuarioService;

import java.util.List;

@Controller
@RequestMapping("Api/v1")
public class AssingController implements InterfaceAssingControll {

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    IMissionService missionService;

    @Override
    @PostMapping("/estudiantes/{id}/misiones")
    public ResponseEntity<String> assingMision(@PathVariable String id,@RequestBody List<String> MisssionIds) {
        usuarioService.assingMission(id, MisssionIds);
        return ResponseEntity.ok().body("Mision Assing");
    }

    @Override
    @PostMapping("/estudiantes/{id}/habilidades")
    public ResponseEntity<String> assign(@PathVariable String id, @RequestBody List<String> habilidadesIds) {
        usuarioService.assingAbility(id,habilidadesIds);
        return ResponseEntity.ok("User successfully assigned to habilidades");
    }

    @Override
    @PostMapping("/mision/{id}/habilidades")
    public ResponseEntity<String> assignHabilityMission(@PathVariable String id, @RequestBody List<String> habilidadesIds) {
        missionService.assingAbility(id,habilidadesIds);
        return ResponseEntity.ok("User successfully assigned to Mission");
    }


}
