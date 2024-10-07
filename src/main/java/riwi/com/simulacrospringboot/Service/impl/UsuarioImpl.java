package riwi.com.simulacrospringboot.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import riwi.com.simulacrospringboot.Repository.HabilidadRepository;
import riwi.com.simulacrospringboot.Repository.MisionRepository;
import riwi.com.simulacrospringboot.Repository.UsuarioRepository;
import riwi.com.simulacrospringboot.Service.interfaces.IUsuarioService;
import riwi.com.simulacrospringboot.exception.ApiException;
import riwi.com.simulacrospringboot.dtos.request.UserRequest;
import riwi.com.simulacrospringboot.dtos.response.UserResponse;
import riwi.com.simulacrospringboot.entities.Habilidad;
import riwi.com.simulacrospringboot.entities.Mision;
import riwi.com.simulacrospringboot.entities.Usuario;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsuarioImpl implements IUsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private HabilidadRepository habilidadRepository;

    @Autowired
    private MisionRepository misionRepository;

    @Override
    public Usuario create(UserRequest request) {


        // dto --> entidad
        Usuario usuario = new Usuario().builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .email(request.getEmail())
                .rol(request.getRol())
                .password(passwordEncoder.encode(request.getPassword()))
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
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
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
            usuario.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        }
        userRepository.save(usuario);
    }

    @Override
    public void assingAbility(String id, List<String> habilidadesIds) {

        Usuario usuario = userRepository.findById(id).orElseThrow(()-> new ApiException("Este usuario no existe"));

        List<Habilidad> habilidades=habilidadRepository.findAllById(habilidadesIds);

        // Error por habilidades no existentes en la base de datos
        if (habilidades.size() != habilidadesIds.size()) {
            throw new ApiException("Una o más habilidades no existen");
        }

        usuario.setHabilidades(habilidades);
        userRepository.save(usuario);

    }

    @Override
    public void assingMission(String id, List<String> MisssionIds) {

        Usuario usuario= userRepository.findById(id).orElseThrow(()-> new ApiException("Este usuario no existe"));

        List<Mision> missions=misionRepository.findAllById(MisssionIds);

        if(missions.size() != MisssionIds.size()) {
            throw  new ApiException("Una o mas misiones no existen, verifique los id");
        }

        //comprobar que el estudiante debe tener las habilidades requeridas para asignar una misión

        missions.forEach(mision -> {
            // Aquí puedes realizar la lógica de verificación de habilidades
            // Ejemplo: Verificar si el usuario tiene las habilidades requeridas para la misión
            boolean tieneHabilidadesRequeridas = mision.getHabilidad_id().stream()
                    .allMatch(habilidadRequerida -> usuario.getHabilidades().contains(habilidadRequerida));

            if (!tieneHabilidadesRequeridas) {
                throw new ApiException("El usuario no tiene las habilidades requeridas para la misión: " + mision.getId());
            }
        });


        usuario.setMision_id(missions);
        userRepository.save(usuario);
    }



}
