package cl.usach.EV1_TINGESO.repositories;

import cl.usach.EV1_TINGESO.entities.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoRepository extends JpaRepository<VehiculoEntity, String> {
}
