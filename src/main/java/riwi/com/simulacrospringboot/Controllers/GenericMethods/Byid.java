package riwi.com.simulacrospringboot.Controllers.GenericMethods;

import org.springframework.http.ResponseEntity;

public interface Byid<ID, Entity> {

    public ResponseEntity<Entity> ById(ID id);
}
