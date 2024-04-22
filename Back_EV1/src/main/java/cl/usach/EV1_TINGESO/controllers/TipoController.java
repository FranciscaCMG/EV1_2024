package cl.usach.EV1_TINGESO.controllers;

import cl.usach.EV1_TINGESO.entities.TipoEntity;
import cl.usach.EV1_TINGESO.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo")
@CrossOrigin("*")
public class TipoController {
    @Autowired
    private TipoService tipoService;

    @GetMapping("/listar")
    public ResponseEntity<List<TipoEntity>> obtenerTipo() {
        List<TipoEntity> tipos = tipoService.obtenerTipo();
        return ResponseEntity.ok(tipos);
    }

    @PostMapping("/guardar")
    public ResponseEntity<TipoEntity> guardarTipo(@RequestBody TipoEntity tipo) {
        TipoEntity tipoGuardado = tipoService.guardarTipo(tipo);
        return ResponseEntity.ok(tipoGuardado);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<TipoEntity> eliminarTipo(@RequestBody TipoEntity tipo) {
        TipoEntity tipoEliminado = tipoService.eliminarTipo(tipo);
        return ResponseEntity.ok(tipoEliminado);
    }

    @DeleteMapping("/eliminar/{patente}")
    public ResponseEntity<TipoEntity> eliminarTipoPorId(@PathVariable String patente) {
        TipoEntity tipoEliminado = tipoService.eliminarTipoPorId(patente);
        return ResponseEntity.ok(tipoEliminado);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<TipoEntity> obtenerTipoPorId(@PathVariable String id) {
        TipoEntity tipo = tipoService.obtenerTipoPorId(id);
        return ResponseEntity.ok(tipo);
    }
}
