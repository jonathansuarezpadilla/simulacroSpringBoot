package riwi.com.simulacrospringboot.Service.interfaces;


import riwi.com.simulacrospringboot.Service.CRUD.AssingAbility;
import riwi.com.simulacrospringboot.Service.CRUD.AssingMission;
import riwi.com.simulacrospringboot.Service.CRUD.Create;
import riwi.com.simulacrospringboot.Service.CRUD.ReadById;
import riwi.com.simulacrospringboot.dtos.request.MisionRequest;
import riwi.com.simulacrospringboot.dtos.response.MissionResponse;
import riwi.com.simulacrospringboot.entities.Mision;

public interface IMissionService extends
        Create<MisionRequest, Mision>,
        ReadById<String, MissionResponse>,
        AssingAbility<String> {


}
