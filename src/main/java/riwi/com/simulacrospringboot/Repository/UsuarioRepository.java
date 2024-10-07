package riwi.com.simulacrospringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import riwi.com.simulacrospringboot.entities.Usuario;

import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findBynombre(String username);

    @Query("select u from  Usuario u where u.nombre=?1")
    Optional<Usuario> getName(String username);
}
