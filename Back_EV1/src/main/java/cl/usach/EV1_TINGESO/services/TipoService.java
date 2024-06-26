package cl.usach.EV1_TINGESO.services;

import cl.usach.EV1_TINGESO.entities.ReparacionEntity;
import cl.usach.EV1_TINGESO.entities.TipoEntity;
import cl.usach.EV1_TINGESO.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TipoService {
    @Autowired
    TipoRepository tipoRepository;

    public ArrayList<TipoEntity> obtenerTipo() {
        return (ArrayList<TipoEntity>) tipoRepository.findAll();
    }

    public TipoEntity guardarTipo(TipoEntity tipo) {
        return tipoRepository.save(tipo);
    }

    public  TipoEntity guardarTipoFuncion(String n_patente, Integer tipo_rep, Float monto) {
        TipoEntity tipo = new TipoEntity();
        tipo.setN_patente(n_patente);
        tipo.setTipo_rep(tipo_rep);
        tipo.setMonto(monto);
        return tipoRepository.save(tipo);
    }

    public TipoEntity eliminarTipo(TipoEntity tipo) {
        tipoRepository.delete(tipo);
        return tipo;
    }
    public TipoEntity obtenerTipoPorId(String id) {
        return tipoRepository.findById(Integer.valueOf(id)).get();
    }

    public TipoEntity eliminarTipoPorId(String patente) {
        Optional<TipoEntity> tipo = tipoRepository.findById(Integer.valueOf(patente));
        if (tipo.isPresent()) {
            tipoRepository.delete(tipo.get());
            return tipo.get();
        }
        return null;

    }

}
