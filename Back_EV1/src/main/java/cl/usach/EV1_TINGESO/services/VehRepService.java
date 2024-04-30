package cl.usach.EV1_TINGESO.services;

import cl.usach.EV1_TINGESO.entities.CostoEntity;
import cl.usach.EV1_TINGESO.entities.VehRepEntity;
import cl.usach.EV1_TINGESO.repositories.CostoRepository;
import cl.usach.EV1_TINGESO.repositories.VehRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VehRepService {
    @Autowired
    VehRepRepository vehRepRepository;

    public ArrayList<VehRepEntity> obtenerVehRep() {
        return (ArrayList<VehRepEntity>) vehRepRepository.findAll();
    }

    public VehRepEntity guardarVehRep(VehRepEntity vehRep) {
        return vehRepRepository.save(vehRep);
    }

    public VehRepEntity eliminarVehRep(VehRepEntity vehRep) {
        vehRepRepository.delete(vehRep);
        return vehRep;
    }

    public VehRepEntity obtenerVehRepPorId(String id) {
        return vehRepRepository.findById(id).get();
    }

    public VehRepEntity eliminarVehRepPorId(String patente) {
        Optional<VehRepEntity> vehRep = vehRepRepository.findById(patente);
        if (vehRep.isPresent()) {
            vehRepRepository.delete(vehRep.get());
            return vehRep.get();
        }
        return null;

    }


    
}
