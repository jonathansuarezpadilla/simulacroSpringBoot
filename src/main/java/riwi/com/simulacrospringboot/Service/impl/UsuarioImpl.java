package riwi.com.simulacrospringboot.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import riwi.com.simulacrospringboot.Repository.UsuarioRepository;
import riwi.com.simulacrospringboot.Service.interfaces.IUsuarioService;
import riwi.com.simulacrospringboot.dtos.exception.ApiException;
import riwi.com.simulacrospringboot.dtos.request.UserRequest;
import riwi.com.simulacrospringboot.dtos.response.UserResponse;
import riwi.com.simulacrospringboot.entities.Usuario;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsuarioImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public Usuario create(UserRequest request) {


        // dto --> entidad
        Usuario usuario = new Usuario().builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .email(request.getEmail())
                .rol(request.getRol())
                .password(request.getPassword())
                .build();

        return userRepository.save(usuario);
    }

    @Override
    public UserResponse readById(String id) {

        //entidad --> userResponse
        Usuario usuario= userRepository.findById(id).orElseThrow(
                ()-> new ApiException("El usuario no existe"));


        UserResponse userResponse = new UserResponse().builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .email(usuario.getEmail())
                .rol(usuario.getRol())
                .build();

        return userResponse ;
    }

    @Override
    public void delete(String id) {
        Usuario usuario= userRepository.findById(id).orElseThrow(
                ()-> new ApiException("El usuario no existe"));
        userRepository.deleteById(id);

    }


    @Override
    public List<UserResponse> readAll() {

        List<UserResponse> list= userRepository.findAll().stream()
                .map(usuario-> new UserResponse().builder()
                        .nombre(usuario.getNombre())
                        .apellido(usuario.getApellido())
                        .email(usuario.getEmail())
                        .rol(usuario.getRol())
                        .build()).collect(Collectors.toList());
        return list;
    }

    @Override
    public void update(UserRequest request, String id) {

        Usuario usuario=userRepository.findById(id).orElseThrow(()-> new ApiException("El usuario no existe"));

        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setRol(request.getRol());
        usuario.setPassword(request.getPassword());
        userRepository.save(usuario);
    }

    @Override
    public void path(UserRequest userRequest, String id) {
        Usuario usuario=userRepository.findById(id).orElseThrow(()-> new ApiException("El usuario no existe"));

        if(userRequest.getNombre()!= null){
            usuario.setNombre(userRequest.getNombre());
        }
        if(userRequest.getApellido()!= null){
            usuario.setApellido(userRequest.getApellido());
        }
        if(userRequest.getEmail()!= null){
            usuario.setEmail(userRequest.getEmail());
        }
        if(userRequest.getRol()!= null){
            usuario.setRol(userRequest.getRol());
        }
        if(userRequest.getPassword()!=null){
            usuario.setPassword(userRequest.getPassword());
        }
        userRepository.save(usuario);
    }
}
