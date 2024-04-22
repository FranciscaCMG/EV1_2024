package cl.usach.EV1_TINGESO.services;

import cl.usach.EV1_TINGESO.entities.ReparacionEntity;
import cl.usach.EV1_TINGESO.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ReparacionService {
    @Autowired
    ReparacionRepository reparacionRepository;

    public ArrayList<ReparacionEntity> obtenerReparacion() {
        return (ArrayList<ReparacionEntity>) reparacionRepository.findAll();
    }

    public ReparacionEntity guardarReparacion(ReparacionEntity reparacion) {
        return reparacionRepository.save(reparacion);
    }

    public ReparacionEntity eliminarReparacion(ReparacionEntity reparacion) {
        reparacionRepository.delete(reparacion);
        return reparacion;
    }


    public ReparacionEntity obtenerReparacionPorId(String id) {
        return reparacionRepository.findById(id).get();
    }

    public ReparacionEntity eliminarReparacionPorId(String patente) {
        Optional<ReparacionEntity> reparacion = reparacionRepository.findById(patente);
        if (reparacion.isPresent()) {
            reparacionRepository.delete(reparacion.get());
            return reparacion.get();
        }
        return null;

    }
}
