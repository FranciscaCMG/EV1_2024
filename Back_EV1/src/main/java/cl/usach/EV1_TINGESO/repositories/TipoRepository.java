package cl.usach.EV1_TINGESO.repositories;

import cl.usach.EV1_TINGESO.entities.TipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<TipoEntity, Integer>{

    @Query("SELECT t.costo FROM TipoEntity t WHERE t.tipo_motor = :tipoMotor AND t.tipo_rep = :tipoRep")
    float findCostoByTipoMotorAndTipoRep(@Param("tipoMotor") String tipoMotor, @Param("tipoRep") String tipoRep);


}
