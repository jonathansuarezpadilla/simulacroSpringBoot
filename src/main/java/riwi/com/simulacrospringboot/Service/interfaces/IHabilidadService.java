package riwi.com.simulacrospringboot.Service.interfaces;

import riwi.com.simulacrospringboot.Service.CRUD.Create;
import riwi.com.simulacrospringboot.Service.CRUD.ReadById;
import riwi.com.simulacrospringboot.dtos.request.HabilidadResquest;
import riwi.com.simulacrospringboot.dtos.response.HabilidadResponse;
import riwi.com.simulacrospringboot.entities.Habilidad;

public interface IHabilidadService extends
        Create<HabilidadResquest, Habilidad>,
        ReadById<String,HabilidadResponse>{
}
