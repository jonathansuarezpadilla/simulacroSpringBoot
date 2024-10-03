package riwi.com.simulacrospringboot.Controllers.GenericMethods;

import org.springframework.http.ResponseEntity;
import riwi.com.simulacrospringboot.dtos.request.UserRequest;

public interface Path <EntityRequest,ID>{
    public ResponseEntity<String> path(EntityRequest request, ID id);
}
