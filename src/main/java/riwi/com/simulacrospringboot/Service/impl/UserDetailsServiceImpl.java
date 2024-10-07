package riwi.com.simulacrospringboot.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import riwi.com.simulacrospringboot.Repository.UsuarioRepository;
import riwi.com.simulacrospringboot.entities.Usuario;


import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario userEntity= usuarioRepository.findBynombre(username)
                .orElseThrow(()->new UsernameNotFoundException("El usuario "+ username + "No existe"));


        Collection<? extends GrantedAuthority> authorities = Collections.singleton(
                new SimpleGrantedAuthority("ROLE_".concat(userEntity.getRol().name())));


        return new User(userEntity.getNombre(),
                userEntity.getPassword(),
                true,true,true,true,authorities);
    }


}
