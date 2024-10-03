package riwi.com.simulacrospringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import riwi.com.simulacrospringboot.entities.Mision;

public interface MisionRepository extends JpaRepository<Mision, String> {
}
