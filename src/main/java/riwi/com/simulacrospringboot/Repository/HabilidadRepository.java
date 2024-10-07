package riwi.com.simulacrospringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import riwi.com.simulacrospringboot.entities.Habilidad;


@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, String> {
}
