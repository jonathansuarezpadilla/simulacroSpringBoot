package riwi.com.simulacrospringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import riwi.com.simulacrospringboot.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
