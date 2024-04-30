package cl.usach.EV1_TINGESO.controllers;

import cl.usach.EV1_TINGESO.entities.CostoEntity;
import cl.usach.EV1_TINGESO.entities.VehRepEntity;
import cl.usach.EV1_TINGESO.services.VehRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehrep")
@CrossOrigin("*")
public class VehRepController {
    @Autowired
    private VehRepService vehRepService;

    @GetMapping("/listar")
    public ResponseEntity<List<VehRepEntity>> obtenerVehRep() {
        List<VehRepEntity> vehReps = vehRepService.obtenerVehRep();
        return ResponseEntity.ok(vehReps);
    }

    @PostMapping("/guardar")
    public ResponseEntity<VehRepEntity> guardarVehRep(@RequestBody VehRepEntity vehRep) {
        VehRepEntity vehRepGuardado = vehRepService.guardarVehRep(vehRep);
        return ResponseEntity.ok(vehRepGuardado);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<VehRepEntity> eliminarVehRep(@RequestBody VehRepEntity vehRep) {
        VehRepEntity vehRepEliminado = vehRepService.eliminarVehRep(vehRep);
        return ResponseEntity.ok(vehRepEliminado);
    }

    @DeleteMapping("/eliminar/{patente}")
    public ResponseEntity<VehRepEntity> eliminarVehRepPorId(@PathVariable String patente) {
        VehRepEntity vehRepEliminado = vehRepService.eliminarVehRepPorId(patente);
        return ResponseEntity.ok(vehRepEliminado);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<VehRepEntity> obtenerVehRepPorId(@PathVariable String id) {
        VehRepEntity vehRep = vehRepService.obtenerVehRepPorId(id);
        return ResponseEntity.ok(vehRep);
    }





}
