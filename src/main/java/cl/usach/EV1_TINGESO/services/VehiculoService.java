package cl.usach.EV1_TINGESO.services;

import cl.usach.EV1_TINGESO.entities.VehiculoEntity;
import cl.usach.EV1_TINGESO.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    public ArrayList<VehiculoEntity> obtenerVehiculo() {
        return (ArrayList<VehiculoEntity>) vehiculoRepository.findAll();
    }

    public VehiculoEntity guardarVehiculo(VehiculoEntity vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
}
