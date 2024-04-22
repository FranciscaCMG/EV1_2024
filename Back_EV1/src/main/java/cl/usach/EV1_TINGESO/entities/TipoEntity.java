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

    private String tipo_rep;
    private String detalle_rep;
    private String tipo_motor;
    private float costo;
}
