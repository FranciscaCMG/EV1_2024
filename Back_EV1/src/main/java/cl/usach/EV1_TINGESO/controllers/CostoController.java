package cl.usach.EV1_TINGESO.controllers;

import cl.usach.EV1_TINGESO.entities.CostoEntity;
import cl.usach.EV1_TINGESO.services.CostoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/costo")
@CrossOrigin("*")
public class CostoController {

    @Autowired
    private CostoService costoService;

    @GetMapping("/tipo/{tipoRep}/{tipoMotor}/{patente}")
    public ResponseEntity<Integer> costoTipo(@PathVariable Integer tipoRep, @PathVariable String tipoMotor, @PathVariable String patente) {
        Integer costotipo = costoService.costoTipo(tipoRep, tipoMotor, patente, true);
        return ResponseEntity.ok(costotipo);
    }


    @GetMapping("/kilometraje/{kilometraje}/{tipoAuto}")
    public ResponseEntity<Integer> costoKilometraje(@PathVariable Integer kilometraje, @PathVariable String tipoAuto) {
        Integer costokilometraje = costoService.costoKilometraje(kilometraje, tipoAuto);
        return ResponseEntity.ok(costokilometraje);
    }

    @GetMapping("/antiguedad/{anio_fabricacion}/{tipoAuto}")
    public ResponseEntity<Integer> costoAntiguedad(@PathVariable String anio_fabricacion, @PathVariable String tipoAuto) {
        Integer costoantiguedad = costoService.costoAntiguedad(anio_fabricacion, tipoAuto);
        return ResponseEntity.ok(costoantiguedad);
    }

    @PostMapping("/total")
    public ResponseEntity<Float> costoTotal(@RequestBody CostoEntity costoEntity) {
        Float costototal = costoService.montoTotal(costoEntity);
        return ResponseEntity.ok(costototal);
    }
}
