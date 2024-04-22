package cl.usach.EV1_TINGESO.controllers;

import cl.usach.EV1_TINGESO.entities.VehiculoEntity;
import cl.usach.EV1_TINGESO.services.VehiculoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@RequestMapping("/vehiculo")
@CrossOrigin("*")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/listar")
    public ResponseEntity<List<VehiculoEntity>> obtenerVehiculo() {
        List<VehiculoEntity> vehiculos = vehiculoService.obtenerVehiculo();
        return ResponseEntity.ok(vehiculos);
    }

    @PostMapping("/guardar")
    public ResponseEntity<VehiculoEntity> guardarVehiculo(@RequestBody VehiculoEntity vehiculo) {
        VehiculoEntity vehiculoGuardado = vehiculoService.guardarVehiculo(vehiculo);
        return ResponseEntity.ok(vehiculoGuardado);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<VehiculoEntity> eliminarVehiculo(@RequestBody VehiculoEntity vehiculo) {
        VehiculoEntity vehiculoEliminado = vehiculoService.eliminarVehiculo(vehiculo);
        return ResponseEntity.ok(vehiculoEliminado);
    }

    @DeleteMapping("/eliminar/{patente}")
    public ResponseEntity<VehiculoEntity> eliminarVehiculoPorId(@PathVariable String patente) {
        VehiculoEntity vehiculoEliminado = vehiculoService.eliminarVehiculoPorId(patente);
        return ResponseEntity.ok(vehiculoEliminado);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<VehiculoEntity> obtenerVehiculoPorId(@PathVariable String id) {
        VehiculoEntity vehiculo = vehiculoService.obtenerVehiculoPorId(id);
        return ResponseEntity.ok(vehiculo);
    }


}
