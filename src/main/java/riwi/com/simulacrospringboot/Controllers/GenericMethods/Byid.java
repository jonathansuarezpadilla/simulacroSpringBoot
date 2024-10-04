package riwi.com.simulacrospringboot.Controllers.GenericMethods;

import org.springframework.http.ResponseEntity;

public interface Byid<ID, EntityResponse> {

    public ResponseEntity<EntityResponse> ById(ID id);
}
