package cl.usach.EV1_TINGESO.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="vehrep")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehRepEntity {
    @Id
    @Column(name = "n_patente", nullable = false)
    private String n_patente;

    private String tipo_rep;
    private String fecha_ing;
    private String hora_ing;

}
