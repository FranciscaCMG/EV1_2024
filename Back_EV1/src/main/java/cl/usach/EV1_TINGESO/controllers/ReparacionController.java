package cl.usach.EV1_TINGESO.controllers;

import cl.usach.EV1_TINGESO.entities.ReparacionEntity;
import cl.usach.EV1_TINGESO.services.ReparacionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @GetMapping("/buscar/{patente}")
    public ResponseEntity<Integer> obtenerReparacionPorPatente(@PathVariable String patente) {
        Integer reparacion = reparacionService.obtenerReparacionPorPatente(patente);
        return ResponseEntity.ok(reparacion);
    }

    @GetMapping("/buscarid/{id}")
    public ResponseEntity<ReparacionEntity> obtenerReparacionPorId(@PathVariable String id) {
        ReparacionEntity reparacion = reparacionService.obtenerReparacionPorId(id);
        return ResponseEntity.ok(reparacion);
    }

    @PatchMapping("/modificarSalida/{id}/{fecha_salida}/{hora_salida}")
    public ResponseEntity<ReparacionEntity> modificarReparacionSalida(@PathVariable String id, @PathVariable String fecha_salida,@PathVariable String hora_salida) {
        ReparacionEntity reparacionModificado = reparacionService.modificarReparacionSalida(id, fecha_salida, hora_salida);
        return ResponseEntity.ok(reparacionModificado);
    }

    @PatchMapping("/modificarListo/{id}/{fecha_salida}/{hora_salida}")
    public ResponseEntity<ReparacionEntity> modificarReparacionListo(@PathVariable String id, @PathVariable String fecha_salida,@PathVariable String hora_salida) {
        ReparacionEntity reparacionModificado = reparacionService.modificarReparacionListo(id, fecha_salida, hora_salida);
        return ResponseEntity.ok(reparacionModificado);
    }

    @GetMapping("/r2")
    public ResponseEntity<List<Map<String, Object>>> tablaR2() {

        float[][] reparaciones = reparacionService.tablaR2();
        List<Map<String, Object>> datos = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            datos.add(Map.of("tipo_rep",i+1, "SEDAN", reparaciones[0][i],
                    "HATCHBACK", reparaciones[1][i], "SUV", reparaciones[2][i],
                    "PICKUP", reparaciones[3][i], "FURGONETA", reparaciones[4][i],
                    "MONTO", reparaciones[5][i]));
        }

        return ResponseEntity.ok(datos);
    }

    @GetMapping("/r4")
    public ResponseEntity<List<Map<String, Object>>> tablaR4() {

        float[][] reparaciones = reparacionService.tablaR4();
        List<Map<String, Object>> datos = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            datos.add(Map.of("tipo_rep",i+1, "DIESEL", reparaciones[0][i],
                    "BENCINA", reparaciones[1][i], "ELECTRICO", reparaciones[2][i],
                    "HIBRIDO", reparaciones[3][i], "MONTO", reparaciones[4][i]));
        }
        return ResponseEntity.ok(datos);
    }

}
