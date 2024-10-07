package riwi.com.simulacrospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import riwi.com.simulacrospringboot.Repository.UsuarioRepository;
import riwi.com.simulacrospringboot.entities.Usuario;
import riwi.com.simulacrospringboot.utils.enumUsuario;

import java.util.Set;

@SpringBootApplication
public class SimulacroSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimulacroSpringBootApplication.class, args);
    }



//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    UsuarioRepository usuarioRepository;
//
//    @Bean
//    CommandLineRunner init() {
//        return args -> {
//            Usuario userEntity = Usuario.builder()
//                    .email("suarezpadillajonathan@gmail.com")
//                    .nombre("Jonathan")
//                    .password(passwordEncoder.encode("1234"))
//                    .rol(enumUsuario.valueOf("ADMIN"))
//                    .build();
//
//
//            usuarioRepository.save(userEntity);
//
//        };

}
