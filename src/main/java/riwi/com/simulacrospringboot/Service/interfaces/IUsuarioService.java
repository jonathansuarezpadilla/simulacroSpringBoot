package riwi.com.simulacrospringboot.Service.interfaces;

import riwi.com.simulacrospringboot.Service.CRUD.*;
import riwi.com.simulacrospringboot.dtos.request.UserRequest;
import riwi.com.simulacrospringboot.dtos.response.UserResponse;
import riwi.com.simulacrospringboot.entities.Usuario;

public interface IUsuarioService extends
        Create<UserRequest, Usuario>,
        ReadById<String,UserResponse>,
        Delete<String>,
        ReadAll<UserResponse>, Put<UserRequest,String>,
        Path<UserRequest,String>{
}
