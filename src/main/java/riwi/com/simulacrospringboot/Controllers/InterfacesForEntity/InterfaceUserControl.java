package riwi.com.simulacrospringboot.Controllers.InterfacesForEntity;

import riwi.com.simulacrospringboot.Controllers.GenericMethods.*;
import riwi.com.simulacrospringboot.dtos.request.UserRequest;
import riwi.com.simulacrospringboot.dtos.response.UserResponse;

public interface InterfaceUserControl extends
        Byid<String, UserResponse>,
        Create<UserRequest,String>,
        Delete<String,String>,
        ReadAll<UserResponse>,
        Put<UserRequest,String>,
        Path<UserRequest,String>,
        AssignAbility<String>{
}
