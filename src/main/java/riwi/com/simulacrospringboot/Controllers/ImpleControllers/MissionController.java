package riwi.com.simulacrospringboot.Controllers.ImpleControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import riwi.com.simulacrospringboot.Controllers.InterfacesForEntity.InterfaceMissionControl;
import riwi.com.simulacrospringboot.Service.interfaces.IMissionService;
import riwi.com.simulacrospringboot.dtos.request.MisionRequest;
import riwi.com.simulacrospringboot.dtos.response.MissionResponse;

@Controller
@RequestMapping("/mission")
public class MissionController implements InterfaceMissionControl {

    @Autowired
    IMissionService missionService;

    @Override
    @PostMapping
    public ResponseEntity<String> create(@RequestBody MisionRequest request) {
        missionService.create(request);
        return ResponseEntity.ok("Mission created");
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MissionResponse> ById(@PathVariable String id) {
        return ResponseEntity.ok(missionService.readById(id));
    }
}
