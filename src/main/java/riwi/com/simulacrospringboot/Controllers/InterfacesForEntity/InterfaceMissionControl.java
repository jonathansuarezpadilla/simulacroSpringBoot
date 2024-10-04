package riwi.com.simulacrospringboot.Controllers.InterfacesForEntity;

import riwi.com.simulacrospringboot.Controllers.GenericMethods.Byid;
import riwi.com.simulacrospringboot.Controllers.GenericMethods.Create;
import riwi.com.simulacrospringboot.dtos.request.MisionRequest;
import riwi.com.simulacrospringboot.dtos.response.MissionResponse;

public interface InterfaceMissionControl extends
        Create<MisionRequest,String>,
        Byid<String,MissionResponse>{
}
