package riwi.com.simulacrospringboot.Controllers.InterfacesForEntity;

import org.springframework.http.ResponseEntity;
import riwi.com.simulacrospringboot.Controllers.GenericMethods.AssignAbility;
import riwi.com.simulacrospringboot.Controllers.GenericMethods.Create;
import riwi.com.simulacrospringboot.Service.CRUD.ReadById;
import riwi.com.simulacrospringboot.dtos.request.HabilidadResquest;
import riwi.com.simulacrospringboot.dtos.response.HabilidadResponse;

public interface InterfaceHabilidadControl extends
        Create<HabilidadResquest,String>,
        ReadById<String, ResponseEntity<HabilidadResponse>>{
}
