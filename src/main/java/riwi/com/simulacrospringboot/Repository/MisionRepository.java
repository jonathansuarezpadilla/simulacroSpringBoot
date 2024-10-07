package riwi.com.simulacrospringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import riwi.com.simulacrospringboot.entities.Mision;


@Repository
public interface MisionRepository extends JpaRepository<Mision, String> {
}
