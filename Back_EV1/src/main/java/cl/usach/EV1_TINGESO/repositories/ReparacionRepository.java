package cl.usach.EV1_TINGESO.repositories;

import cl.usach.EV1_TINGESO.entities.ReparacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparacionRepository extends JpaRepository<ReparacionEntity, String> {
}
