package cl.usach.EV1_TINGESO.controllers;

import cl.usach.EV1_TINGESO.entities.ReparacionEntity;
import cl.usach.EV1_TINGESO.services.ReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reparacion")
@CrossOrigin("*")
public class ReparacionController {
    @Autowired
    private ReparacionService reparacionService;

    @GetMapping("/listar")
    public ResponseEntity<List<ReparacionEntity>> obtenerReparacion() {
        List<ReparacionEntity> reparaciones = reparacionService.obtenerReparacion();
        return ResponseEntity.ok(reparaciones);
    }

    @PostMapping("/guardar")
    public ResponseEntity<ReparacionEntity> guardarReparacion(@RequestBody ReparacionEntity reparacion) {
        ReparacionEntity reparacionGuardado = reparacionService.guardarReparacion(reparacion);
        return ResponseEntity.ok(reparacionGuardado);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<ReparacionEntity> eliminarReparacion(@RequestBody ReparacionEntity reparacion) {
        ReparacionEntity reparacionEliminado = reparacionService.eliminarReparacion(reparacion);
        return ResponseEntity.ok(reparacionEliminado);
    }

    @DeleteMapping("/eliminar/{patente}")
    public ResponseEntity<ReparacionEntity> eliminarReparacionPorId(@PathVariable String patente) {
        ReparacionEntity reparacionEliminado = reparacionService.eliminarReparacionPorId(patente);
        return ResponseEntity.ok(reparacionEliminado);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ReparacionEntity> obtenerReparacionPorId(@PathVariable String id) {
        ReparacionEntity reparacion = reparacionService.obtenerReparacionPorId(id);
        return ResponseEntity.ok(reparacion);
    }
}
