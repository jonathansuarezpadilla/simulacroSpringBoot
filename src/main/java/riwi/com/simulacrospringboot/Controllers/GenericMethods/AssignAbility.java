package riwi.com.simulacrospringboot.Controllers.GenericMethods;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AssignAbility <ID>{

    public ResponseEntity<String> assign(ID id, List<ID> habilidadesIds);
}
