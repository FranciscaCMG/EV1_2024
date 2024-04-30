package cl.usach.EV1_TINGESO.services;

import cl.usach.EV1_TINGESO.entities.ReparacionEntity;
import cl.usach.EV1_TINGESO.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
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

    public Integer obtenerReparacionPorPatente(String patente) {
        return reparacionRepository.findByPatente(patente);
    }

    public ReparacionEntity obtenerReparacionPorId(String id) {
        Optional<ReparacionEntity> reparacion = reparacionRepository.findById(id);
        if (reparacion.isPresent()) {
            return reparacion.get();
        } else {
            return null;
        }
    }
    public Integer reparaciondesc(String patente, String tipoMotor){
        int cantidad = obtenerReparacionPorPatente(patente);
        switch (tipoMotor){
            case "GASOLINA":
                if (cantidad>=1 && cantidad<=2){
                    return 5;
                }else if (cantidad>=3 && cantidad<=5){
                    return 10;

                }else if (cantidad>=6 && cantidad<=9) {
                    return 15;
                } else if (cantidad>=10) {
                    return 20;
                }else {
                    return 0;
                }
            case "DIESEL":
                if (cantidad>=1 && cantidad<=2){
                    return 7;
                }else if (cantidad>=3 && cantidad<=5){
                    return 12;

                }else if (cantidad>=6 && cantidad<=9) {
                    return 17;
                } else if (cantidad>=10) {
                    return 22;
                }else {
                    return 0;
                }
            case "HIBRIDO":
                if (cantidad>=1 && cantidad<=2){
                    return 10;
                }else if (cantidad>=3 && cantidad<=5){
                    return 15;

                }else if (cantidad>=6 && cantidad<=9) {
                    return 20;
                } else if (cantidad>=10) {
                    return 25;
                }else {
                    return 0;
                }
            case "ELECTRICO":
                if (cantidad>=1 && cantidad<=2){
                    return 8;
                }else if (cantidad>=3 && cantidad<=5){
                    return 13;

                }else if (cantidad>=6 && cantidad<=9) {
                    return 18;
                } else if (cantidad>=10) {
                    return 23;
                }else {
                    return 0;
                }
        }
        return -1;
    }

    public ReparacionEntity modificarReparacionListo(String id, String fecha_salida, String hora_salida) {
        Optional<ReparacionEntity> reparacion = reparacionRepository.findById(id);
        if (reparacion.isPresent()) {
            ReparacionEntity reparacionEntity = reparacion.get();
            reparacionEntity.setFecha_sal(fecha_salida);
            reparacionEntity.setHora_sal(hora_salida);
            return reparacionRepository.save(reparacionEntity);
        } else {
            return null;
        }
    }

    public static long calcularDiasTranscurridos(String fechaInicio, String fechaFin) {
        // Definir el formato de las fechas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Convertir las fechas de String a LocalDate
        LocalDate fechaInicial = LocalDate.parse(fechaInicio, formatter);
        LocalDate fechaFinal = LocalDate.parse(fechaFin, formatter);

        // Calcular la diferencia de días entre las dos fechas
        long diasTranscurridos = ChronoUnit.DAYS.between(fechaInicial, fechaFinal);

        // Retornar el número de días transcurridos
        return diasTranscurridos;
    }

    public ReparacionEntity modificarReparacionSalida(String id, String fecha_salida, String hora_salida) {

        Optional<ReparacionEntity> reparacion = reparacionRepository.findById(id);
        if (reparacion.isPresent()) {
            long dias_transcurridos = calcularDiasTranscurridos( reparacion.get().getFecha_sal(),fecha_salida);
            System.out.println("Dias trans");
            System.out.println(dias_transcurridos);
            if (dias_transcurridos > 0) {
                System.out.println("entro");
                ReparacionEntity reparacionEntity = reparacion.get();


                float monto_final = reparacion.get().getMonto_total()*(1 +(dias_transcurridos * 5)/100);
                System.out.println(monto_final);
                reparacionEntity.setFecha_sal_cli(fecha_salida);
                reparacionEntity.setHora_sal_cli(hora_salida);
                reparacionEntity.setMonto_total(monto_final);
                return reparacionRepository.save(reparacionEntity);
            } else {
            ReparacionEntity reparacionEntity = reparacion.get();
            reparacionEntity.setFecha_sal_cli(fecha_salida);
            reparacionEntity.setHora_sal_cli(hora_salida);

            return reparacionRepository.save(reparacionEntity);
        }
        }
        return null;
    }

    public float[][] tablaR2() {

        List<String> tabla = reparacionRepository.tablaR2();
        Integer largo = tabla.size();

        float[] cant_sedan = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        float[] cant_hatchback = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        float[] cant_suv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        float[] cant_pickup = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        float[] cant_furgoneta = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        float[] monto = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};


        for (int i = 0; i < largo; i++) {

            String[] tablas_arg = tabla.get(i).split(",");
            String tipo_arg = tablas_arg[0];
            String monto_arg = tablas_arg[1];
            String tipo_auto_arg = tablas_arg[2];

            Integer tipo_arg_int = Integer.parseInt(tipo_arg);
            Float monto_arg_float = Float.parseFloat(monto_arg);

            //Sedán Hatchback SUV Pickup Furgoneta

            switch (tipo_arg_int){
                case 1:
                    if (tipo_auto_arg.equals("SEDAN")){
                        cant_sedan[0] += 1;
                        monto[0] += monto_arg_float;

                    }else if (tipo_auto_arg.equals("HATCHBACK")){
                        cant_hatchback[0] += 1;
                        monto[0] += monto_arg_float;

                    }else if (tipo_auto_arg.equals("SUV")){
                        cant_suv[0] += 1;
                        monto[0] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("PICKUP")){
                        cant_pickup[0] += 1;
                        monto[0] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("FURGONETA")){
                        cant_furgoneta[0] += 1;
                        monto[0] += monto_arg_float;
                    }
                    break;
                case 2:
                    if (tipo_auto_arg.equals("SEDAN")){
                        cant_sedan[1] += 1;
                        monto[1] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("HATCHBACK")){
                        cant_hatchback[1] += 1;
                        monto[1] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("SUV")){
                        cant_suv[1] += 1;
                        monto[1] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("PICKUP")){
                        cant_pickup[1] += 1;
                        monto[1] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("FURGONETA")){
                        cant_furgoneta[1] += 1;
                        monto[1] += monto_arg_float;
                    }
                    break;
                case 3:
                    if (tipo_auto_arg.equals("SEDAN")){
                        cant_sedan[2] += 1;
                        monto[2] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("HATCHBACK")){
                        cant_hatchback[2] += 1;
                        monto[2] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("SUV")){
                        cant_suv[2] += 1;
                        monto[2] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("PICKUP")){
                        cant_pickup[2] += 1;
                        monto[2] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("FURGONETA")){
                        cant_furgoneta[2] += 1;
                        monto[2] += monto_arg_float;
                    }
                    break;
                case 4:
                    if (tipo_auto_arg.equals("SEDAN")){
                        cant_sedan[3] += 1;
                        monto[3] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("HATCHBACK")){
                        cant_hatchback[3] += 1;
                        monto[3] += monto_arg_float;
                    }
                    else if (tipo_auto_arg.equals("SUV")){
                        cant_suv[3] += 1;
                        monto[3] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("PICKUP")){
                        cant_pickup[3] += 1;
                        monto[3] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("FURGONETA")){
                        cant_furgoneta[3] += 1;
                        monto[3] += monto_arg_float;
                    }
                    break;
                case 5:
                    if (tipo_auto_arg.equals("SEDAN")){
                        cant_sedan[4] += 1;
                        monto[4] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("HATCHBACK")){
                        cant_hatchback[4] += 1;
                        monto[4] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("SUV")){
                        cant_suv[4] += 1;
                        monto[4] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("PICKUP")){
                        cant_pickup[4] += 1;
                        monto[4] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("FURGONETA")){
                        cant_furgoneta[4] += 1;
                        monto[4] += monto_arg_float;
                    }
                    break;
                case 6:
                    if (tipo_auto_arg.equals("SEDAN")){
                        cant_sedan[5] += 1;
                        monto[5] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("HATCHBACK")){
                        cant_hatchback[5] += 1;
                        monto[5] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("SUV")){
                        cant_suv[5] += 1;
                        monto[5] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("PICKUP")){
                        cant_pickup[5] += 1;
                        monto[5] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("FURGONETA")){
                        cant_furgoneta[5] += 1;
                        monto[5] += monto_arg_float;
                    }
                    break;
                case 7:
                    if (tipo_auto_arg.equals("SEDAN")){
                        cant_sedan[6] += 1;
                        monto[6] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("HATCHBACK")){
                        cant_hatchback[6] += 1;
                        monto[6] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("SUV")){
                        cant_suv[6] += 1;
                        monto[6] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("PICKUP")){
                        cant_pickup[6] += 1;
                        monto[6] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("FURGONETA")){
                        cant_furgoneta[6] += 1;
                        monto[6] += monto_arg_float;
                    }
                    break;
                case 8:
                    if (tipo_auto_arg.equals("SEDAN")){
                        cant_sedan[7] += 1;
                        monto[7] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("HATCHBACK")){
                        cant_hatchback[7] += 1;
                        monto[7] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("SUV")){
                        cant_suv[7] += 1;
                        monto[7] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("PICKUP")){
                        cant_pickup[7] += 1;
                        monto[7] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("FURGONETA")){
                        cant_furgoneta[7] += 1;
                        monto[7] += monto_arg_float;
                    }
                    break;
                case 9:
                    if (tipo_auto_arg.equals("SEDAN")){
                        cant_sedan[8] += 1;
                        monto[8] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("HATCHBACK")){
                        cant_hatchback[8] += 1;
                        monto[8] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("SUV")){
                        cant_suv[8] += 1;
                        monto[8] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("PICKUP")){
                        cant_pickup[8] += 1;
                        monto[8] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("FURGONETA")){
                        cant_furgoneta[8] += 1;
                        monto[8] += monto_arg_float;
                    }
                    break;
                case 10:
                    if (tipo_auto_arg.equals("SEDAN")){
                        cant_sedan[9] += 1;
                        monto[9] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("HATCHBACK")){
                        cant_hatchback[9] += 1;
                        monto[9] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("SUV")){
                        cant_suv[9] += 1;
                        monto[9] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("PICKUP")){
                        cant_pickup[9] += 1;
                        monto[9] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("FURGONETA")){
                        cant_furgoneta[9] += 1;
                        monto[9] += monto_arg_float;
                    }
                    break;
                case 11:
                    if (tipo_auto_arg.equals("SEDAN")){
                        cant_sedan[10] += 1;
                        monto[10] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("HATCHBACK")){
                        cant_hatchback[10] += 1;
                        monto[10] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("SUV")){
                        cant_suv[10] += 1;
                        monto[10] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("PICKUP")){
                        cant_pickup[10] += 1;
                        monto[10] += monto_arg_float;
                    }else if (tipo_auto_arg.equals("FUARGONETA")){
                        cant_furgoneta[10] += 1;
                        monto[10] += monto_arg_float;
                    }
                    break;

            }
        }

        float[][] tablaFinal = {cant_sedan, cant_hatchback, cant_suv, cant_pickup, cant_furgoneta, monto};

        return tablaFinal;
    }

    public float[][] tablaR4() {

        List<String> tabla = reparacionRepository.tablaR4();
        Integer largo = tabla.size();

        float[] cant_gasolina = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        float[] cant_diesel = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        float[] cant_hibrido = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        float[] cant_electrico = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        float[] monto = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < largo; i++) {

            String[] tablas_arg = tabla.get(i).split(",");
            String tipo_arg = tablas_arg[0];
            String monto_arg = tablas_arg[1];
            String tipo_motor_arg = tablas_arg[2];

            Integer tipo_arg_int = Integer.parseInt(tipo_arg);
            Float monto_arg_float = Float.parseFloat(monto_arg);

            switch (tipo_arg_int) {
                case 1:
                    if (tipo_motor_arg.equals("GASOLINA")) {
                        cant_gasolina[0] += 1;
                        monto[0] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("DIESEL")) {
                        cant_diesel[0] += 1;
                        monto[0] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("HIBRIDO")) {
                        cant_hibrido[0] += 1;
                        monto[0] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("ELECTRICO")) {
                        cant_electrico[0] += 1;
                        monto[0] += monto_arg_float;
                    }
                    break;
                case 2:
                    if (tipo_motor_arg.equals("GASOLINA")) {
                        cant_gasolina[1] += 1;
                        monto[1] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("DIESEL")) {
                        cant_diesel[1] += 1;
                        monto[1] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("HIBRIDO")) {
                        cant_hibrido[1] += 1;
                        monto[1] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("ELECTRICO")) {
                        cant_electrico[1] += 1;
                        monto[1] += monto_arg_float;
                    }
                    break;
                case 3:
                    if (tipo_motor_arg.equals("GASOLINA")) {
                        cant_gasolina[2] += 1;
                        monto[2] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("DIESEL")) {
                        cant_diesel[2] += 1;
                        monto[2] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("HIBRIDO")) {
                        cant_hibrido[2] += 1;
                        monto[2] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("ELECTRICO")) {
                        cant_electrico[2] += 1;
                        monto[2] += monto_arg_float;
                    }
                    break;
                case 4:
                    if (tipo_motor_arg.equals("GASOLINA")) {
                        cant_gasolina[3] += 1;
                        monto[3] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("DIESEL")) {
                        cant_diesel[3] += 1;
                        monto[3] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("HIBRIDO")) {
                        cant_hibrido[3] += 1;
                        monto[3] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("ELECTRICO")) {
                        cant_electrico[3] += 1;
                        monto[3] += monto_arg_float;
                    }
                    break;
                case 5:
                    if (tipo_motor_arg.equals("GASOLINA")) {
                        cant_gasolina[4] += 1;
                        monto[4] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("DIESEL")) {
                        cant_diesel[4] += 1;
                        monto[4] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("HIBRIDO")) {
                        cant_hibrido[4] += 1;
                        monto[4] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("ELECTRICO")) {
                        cant_electrico[4] += 1;
                        monto[4] += monto_arg_float;
                    }
                    break;
                case 6:
                    if (tipo_motor_arg.equals("GASOLINA")) {
                        cant_gasolina[5] += 1;
                        monto[5] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("DIESEL")) {
                        cant_diesel[5] += 1;
                        monto[5] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("HIBRIDO")) {
                        cant_hibrido[5] += 1;
                        monto[5] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("ELECTRICO")) {
                        cant_electrico[5] += 1;
                        monto[5] += monto_arg_float;
                    }
                    break;
                case 7:
                    if (tipo_motor_arg.equals("GASOLINA")) {
                        cant_gasolina[6] += 1;
                        monto[6] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("DIESEL")) {
                        cant_diesel[6] += 1;
                        monto[6] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("HIBRIDO")) {
                        cant_hibrido[6] += 1;
                        monto[6] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("ELECTRICO")) {
                        cant_electrico[6] += 1;
                        monto[6] += monto_arg_float;
                    }
                    break;
                case 8:
                    if (tipo_motor_arg.equals("GASOLINA")) {
                        cant_gasolina[7] += 1;
                        monto[7] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("DIESEL")) {
                        cant_diesel[7] += 1;
                        monto[7] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("HIBRIDO")) {
                        cant_hibrido[7] += 1;
                        monto[7] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("ELECTRICO")) {
                        cant_electrico[7] += 1;
                        monto[7] += monto_arg_float;
                    }
                    break;
                case 9:
                    if (tipo_motor_arg.equals("GASOLINA")) {
                        cant_gasolina[8] += 1;
                        monto[8] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("DIESEL")) {
                        cant_diesel[8] += 1;
                        monto[8] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("HIBRIDO")) {
                        cant_hibrido[8] += 1;
                        monto[8] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("ELECTRICO")) {
                        cant_electrico[8] += 1;
                        monto[8] += monto_arg_float;
                    }
                    break;
                case 10:
                    if (tipo_motor_arg.equals("GASOLINA")) {
                        cant_gasolina[9] += 1;
                        monto[9] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("DIESEL")) {
                        cant_diesel[9] += 1;
                        monto[9] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("HIBRIDO")) {
                        cant_hibrido[9] += 1;
                        monto[9] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("ELECTRICO")) {
                        cant_electrico[9] += 1;
                        monto[9] += monto_arg_float;
                    }
                    break;
                case 11:
                    if (tipo_motor_arg.equals("GASOLINA")) {
                        cant_gasolina[10] += 1;
                        monto[10] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("DIESEL")) {
                        cant_diesel[10] += 1;
                        monto[10] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("HIBRIDO")) {
                        cant_hibrido[10] += 1;
                        monto[10] += monto_arg_float;
                    } else if (tipo_motor_arg.equals("ELECTRICO")) {
                        cant_electrico[10] += 1;
                        monto[10] += monto_arg_float;
                    }
                    break;
            }
        }

        float[][] tablaFinal = {cant_gasolina, cant_diesel, cant_hibrido, cant_electrico, monto};

        return tablaFinal;
    }
}
