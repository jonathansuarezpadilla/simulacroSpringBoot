package riwi.com.simulacrospringboot.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riwi.com.simulacrospringboot.Repository.HabilidadRepository;
import riwi.com.simulacrospringboot.Repository.MisionRepository;
import riwi.com.simulacrospringboot.Service.interfaces.IMissionService;
import riwi.com.simulacrospringboot.dtos.exception.ApiException;
import riwi.com.simulacrospringboot.dtos.request.MisionRequest;
import riwi.com.simulacrospringboot.dtos.response.MissionResponse;
import riwi.com.simulacrospringboot.entities.Habilidad;
import riwi.com.simulacrospringboot.entities.Mision;
import riwi.com.simulacrospringboot.entities.Usuario;

import java.util.List;

@Service
public class MissionImpl implements IMissionService {

    @Autowired
    MisionRepository misionRepository;

    @Autowired
    HabilidadRepository habilidadRepository;

    @Override
    public Mision create(MisionRequest missionRequest) {

        //DTO-> entity
        Mision mission = new Mision().builder()

                .completada(missionRequest.getCompletada())
                .nivel(missionRequest.getNivel())
                .puntos(missionRequest.getPuntos())
                .descripcion(missionRequest.getDescripcion())
                .titulo(missionRequest.getTitulo())
                .build();
        return misionRepository.save(mission);
    }

    @Override
    public MissionResponse readById(String id) {

        Mision mission = misionRepository.findById(id).orElseThrow(()-> new ApiException("Esta misión no existe"));

        //Entity -> DTO

        MissionResponse missionResponse = new MissionResponse().builder()
                .id(mission.getId())
                .completada(mission.getCompletada())
                .nivel(mission.getNivel())
                .puntos(mission.getPuntos())
                .descripcion(mission.getDescripcion())
                .titulo(mission.getTitulo())
                .build();

        return missionResponse;
    }

    @Override
    public void assingAbility(String id, List<String> habilidadesIds) {

        Mision mision = misionRepository.findById(id).orElseThrow(()-> new ApiException("Esta misión no existe"));

        List<Habilidad> habilidades=habilidadRepository.findAllById(habilidadesIds);

        // Error por habilidades no existentes en la base de datos
        if (habilidades.size() != habilidadesIds.size()) {
            throw new ApiException("Una o más habilidades no existen");
        }

        mision.setHabilidad_id(habilidades);
        misionRepository.save(mision);
    }
}
