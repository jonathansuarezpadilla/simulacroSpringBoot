package riwi.com.simulacrospringboot.Controllers.GenericMethods;

import org.springframework.http.ResponseEntity;

public interface Create<EntityRequest,Entity> {

    public ResponseEntity<Entity> create(EntityRequest entity);

}
