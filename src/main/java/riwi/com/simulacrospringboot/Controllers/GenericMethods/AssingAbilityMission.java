package riwi.com.simulacrospringboot.Controllers.GenericMethods;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AssingAbilityMission<ID> {
    public ResponseEntity<String> assignHabilityMission(ID id, List<ID> habilidadesIds);
}
