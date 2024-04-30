package cl.usach.EV1_TINGESO.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tipo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer ID;

    private String n_patente;
    private Integer tipo_rep;
    private Float monto;
}
