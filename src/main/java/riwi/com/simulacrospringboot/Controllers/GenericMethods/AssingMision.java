package riwi.com.simulacrospringboot.Controllers.GenericMethods;


import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AssingMision<ID> {
    public ResponseEntity<ID> assingMision(ID id, List<ID> MisssionIds );
}
