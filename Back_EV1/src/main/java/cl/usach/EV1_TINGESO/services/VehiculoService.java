package cl.usach.EV1_TINGESO.services;

import cl.usach.EV1_TINGESO.entities.VehiculoEntity;
import cl.usach.EV1_TINGESO.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

    public VehiculoEntity eliminarVehiculo(VehiculoEntity vehiculo) {
        vehiculoRepository.delete(vehiculo);
        return vehiculo;
    }


    public VehiculoEntity obtenerVehiculoPorId(String id) {
        return vehiculoRepository.findById(id).get();
    }

    public VehiculoEntity eliminarVehiculoPorId(String patente) {
        Optional<VehiculoEntity> vehiculo = vehiculoRepository.findById(patente);
        if (vehiculo.isPresent()) {
            vehiculoRepository.delete(vehiculo.get());
            return vehiculo.get();
        }
        return null;

    }

}
