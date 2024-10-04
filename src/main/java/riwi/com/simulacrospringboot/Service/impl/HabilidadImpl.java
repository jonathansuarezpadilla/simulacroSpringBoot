package riwi.com.simulacrospringboot.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riwi.com.simulacrospringboot.Repository.HabilidadRepository;
import riwi.com.simulacrospringboot.Service.interfaces.IHabilidadService;
import riwi.com.simulacrospringboot.exception.ApiException;
import riwi.com.simulacrospringboot.dtos.request.HabilidadResquest;
import riwi.com.simulacrospringboot.dtos.response.HabilidadResponse;
import riwi.com.simulacrospringboot.entities.Habilidad;


@Service
public class HabilidadImpl implements IHabilidadService {

    @Autowired
    private HabilidadRepository habilidadRepository;

    @Override
    public Habilidad create(HabilidadResquest habilidadResquest) {

        //DTO -> Entityt
        Habilidad habilidad = new Habilidad().builder()
                .nombre(habilidadResquest.getNombre())
                .descripcion(habilidadResquest.getDescripcion())
                .build();

        return habilidadRepository.save(habilidad);
    }


    @Override
    public HabilidadResponse readById(String id) {

        Habilidad habilidad = habilidadRepository.findById(id).orElseThrow(()-> new ApiException("Esta habilidad no existe"));

        //entity-> DTO
        HabilidadResponse habilidadResponse = new HabilidadResponse().builder()
                .id(habilidad.getId())
                .nombre(habilidad.getNombre())
                .descripcion(habilidad.getDescripcion())
                .build();

        return habilidadResponse;
    }
}
