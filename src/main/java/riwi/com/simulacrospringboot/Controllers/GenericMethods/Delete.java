package riwi.com.simulacrospringboot.Controllers.GenericMethods;

import org.springframework.http.ResponseEntity;

public interface Delete <Entity,ID> {

    public ResponseEntity<Entity> delete(ID id);
}
