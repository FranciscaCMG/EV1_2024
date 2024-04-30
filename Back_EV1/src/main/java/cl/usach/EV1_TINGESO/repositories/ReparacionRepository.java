package cl.usach.EV1_TINGESO.repositories;

import cl.usach.EV1_TINGESO.entities.ReparacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReparacionRepository extends JpaRepository<ReparacionEntity, String> {

    @Query(value = "SELECT COUNT(*) FROM reparacion WHERE n_patente = :patente", nativeQuery = true)
    Integer findByPatente(@Param("patente") String patente);

    @Query(value = "SELECT t.tipo_rep, t.monto, v.tipo_auto FROM tipo t JOIN vehiculo v ON t.n_patente = v.n_patente ", nativeQuery = true)
    List<String> tablaR2();

    @Query(value = "SELECT t.tipo_rep, t.monto, v.tipo_motor FROM tipo t JOIN vehiculo v ON t.n_patente = v.n_patente ", nativeQuery = true)
    List<String> tablaR4();

}
