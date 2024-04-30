package cl.usach.EV1_TINGESO.services;

import cl.usach.EV1_TINGESO.entities.CostoEntity;
import cl.usach.EV1_TINGESO.entities.TipoEntity;
import cl.usach.EV1_TINGESO.repositories.CostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostoService {

    @Autowired
    CostoRepository costoRepository;

    @Autowired
    ReparacionService reparacionService;

    @Autowired
    TipoService tipoService;

    Integer anio_actual= 2024;
    Integer cantToyota = 5;
    Integer cantFord = 2;
    Integer cantHyundai = 1;
    Integer cantHonda = 7;

    public Integer costoTipo(Integer tipoRep, String tipoMotor, String n_patente, Boolean bandera) {

        Integer valor = -1;

        if (tipoRep == 1) {
            if (tipoMotor.equals("GASOLINA")) {
                valor = 120000;
            } else if (tipoMotor.equals("DIESEL")) {
                valor = 120000;
            } else if (tipoMotor.equals("HIBRIDO")) {
                valor = 180000;
            } else if (tipoMotor.equals("ELECTRICO")) {
                valor = 220000;
            }
        } else if (tipoRep == 2) {
            if (tipoMotor.equals("GASOLINA")) {
                valor = 130000;
            } else if (tipoMotor.equals("DIESEL")) {
                valor = 130000;
            } else if (tipoMotor.equals("HIBRIDO")) {
                valor = 190000;
            } else if (tipoMotor.equals("ELECTRICO")) {
                valor = 230000;
            }
        } else if (tipoRep == 3) {
            if (tipoMotor.equals("GASOLINA")) {
                valor = 350000;
            } else if (tipoMotor.equals("DIESEL")) {
                valor = 450000;
            } else if (tipoMotor.equals("HIBRIDO")) {
                valor = 700000;
            } else if (tipoMotor.equals("ELECTRICO")) {
                valor = 800000;
            }
        } else if (tipoRep == 4) {
            if (tipoMotor.equals("GASOLINA")) {
                valor = 210000;
            } else if (tipoMotor.equals("DIESEL")) {
                valor = 210000;
            } else if (tipoMotor.equals("HIBRIDO")) {
                valor = 300000;
            } else if (tipoMotor.equals("ELECTRICO")) {
                valor = 300000;
            }
        } else if (tipoRep == 5) {
            if (tipoMotor.equals("GASOLINA")) {
                valor = 150000;
            } else if (tipoMotor.equals("DIESEL")) {
                valor = 150000;
            } else if (tipoMotor.equals("HIBRIDO")) {
                valor = 200000;
            } else if (tipoMotor.equals("ELECTRICO")) {
                valor = 250000;
            }
        } else if (tipoRep == 6) {
            if (tipoMotor.equals("GASOLINA")) {
                valor = 100000;
            } else if (tipoMotor.equals("DIESEL")) {
                valor = 120000;
            } else if (tipoMotor.equals("HIBRIDO")) {
                valor = 450000;
            } else if (tipoMotor.equals("ELECTRICO")) {
                valor = 0;
            }
        } else if (tipoRep == 7) {
            if (tipoMotor.equals("GASOLINA")) {
                valor = 100000;
            } else if (tipoMotor.equals("DIESEL")) {
                valor = 100000;
            } else if (tipoMotor.equals("HIBRIDO")) {
                valor = 100000;
            } else if (tipoMotor.equals("ELECTRICO")) {
                valor = 100000;
            }
        } else if (tipoRep == 8) {
            if (tipoMotor.equals("GASOLINA")) {
                valor = 180000;
            } else if (tipoMotor.equals("DIESEL")) {
                valor = 180000;
            } else if (tipoMotor.equals("HIBRIDO")) {
                valor = 210000;
            } else if (tipoMotor.equals("ELECTRICO")) {
                valor = 250000;
            }
        } else if (tipoRep == 9) {
            if (tipoMotor.equals("GASOLINA")) {
                valor = 150000;
            } else if (tipoMotor.equals("DIESEL")) {
                valor = 150000;
            } else if (tipoMotor.equals("HIBRIDO")) {
                valor = 180000;
            } else if (tipoMotor.equals("ELECTRICO")) {
                valor = 180000;
            }
        } else if (tipoRep == 10) {
            if (tipoMotor.equals("GASOLINA")) {
                valor = 130000;
            } else if (tipoMotor.equals("DIESEL")) {
                valor = 140000;
            } else if (tipoMotor.equals("HIBRIDO")) {
                valor = 220000;
            } else if (tipoMotor.equals("ELECTRICO")) {
                valor = 0;
            }
        } else if (tipoRep == 11) {
            if (tipoMotor.equals("GASOLINA")) {
                valor = 80000;
            } else if (tipoMotor.equals("DIESEL")) {
                valor = 80000;
            } else if (tipoMotor.equals("HIBRIDO")) {
                valor = 80000;
            } else if (tipoMotor.equals("ELECTRICO")) {
                valor = 80000;
            }
        }

        if(bandera){
            Float valorFlotante = valor.floatValue();
            tipoService.guardarTipoFuncion(n_patente, tipoRep, valorFlotante);
        }

        return valor;
    }

    public Integer costoKilometraje(Integer kilometraje, String tipoAuto) {

        switch (tipoAuto) {
            case "SEDAN":
                if (kilometraje >= 0 && kilometraje <= 5000) {
                    return (0);
                } else if (kilometraje >= 5001 && kilometraje <= 12000) {
                    return (3);
                } else if (kilometraje >= 12001 && kilometraje <= 25000) {
                    return (7);
                } else if (kilometraje >= 25001 && kilometraje <= 40000) {
                    return (12);
                } else if (kilometraje >= 40001) {
                    return (20);
                }
            case "HATCHBACK":
                if (kilometraje >= 0 && kilometraje <= 5000) {
                    return (0);
                } else if (kilometraje >= 5001 && kilometraje <= 12000) {
                    return (3);
                } else if (kilometraje >= 12001 && kilometraje <= 25000) {
                    return (7);
                } else if (kilometraje >= 25001 && kilometraje <= 40000) {
                    return (12);
                } else if (kilometraje >= 40001) {
                    return (20);
                }
            case "SUV":
                if (kilometraje >= 0 && kilometraje <= 5000) {
                    return (0);
                } else if (kilometraje >= 5001 && kilometraje <= 12000) {
                    return (5);
                } else if (kilometraje >= 12001 && kilometraje <= 25000) {
                    return (9);
                } else if (kilometraje >= 25001 && kilometraje <= 40000) {
                    return (12);
                } else if (kilometraje >= 40001) {
                    return (20);
                }
            case "PICKUP":
                if (kilometraje >= 0 && kilometraje <= 5000) {
                    return (0);
                } else if (kilometraje >= 5001 && kilometraje <= 12000) {
                    return (5);
                } else if (kilometraje >= 12001 && kilometraje <= 25000) {
                    return (9);
                } else if (kilometraje >= 25001 && kilometraje <= 40000) {
                    return (12);
                } else if (kilometraje >= 40001) {
                    return (20);
                }
            case "FURGONETA":
                if (kilometraje >= 0 && kilometraje <= 5000) {
                    return (0);
                } else if (kilometraje >= 5001 && kilometraje <= 12000) {
                    return (5);
                } else if (kilometraje >= 12001 && kilometraje <= 25000) {
                    return (9);
                } else if (kilometraje >= 25001 && kilometraje <= 40000) {
                    return (12);
                } else if (kilometraje >= 40001) {
                    return (20);
                }
        }
        return -1;
    }

    public Integer costoAntiguedad(String anio_fabricacion, String tipoAuto) {
        Integer anio_fabricacion_int = Integer.parseInt(anio_fabricacion);
        Integer antiguedad = anio_actual - anio_fabricacion_int;
        switch (tipoAuto) {
            case "SEDAN":
                if (antiguedad >= 0 && antiguedad <= 5) {
                    return (0);
                } else if (antiguedad >= 6 && antiguedad <= 10) {
                    return (5);
                } else if (antiguedad >= 11 && antiguedad <= 15) {
                    return (9);
                } else if (antiguedad >= 16 ) {
                    return (15);
                }
            case "HATCHBACK":
                if (antiguedad >= 0 && antiguedad <= 5) {
                    return (0);
                } else if (antiguedad >= 6 && antiguedad <= 10) {
                    return (5);
                } else if (antiguedad >= 11 && antiguedad <= 15) {
                    return (9);
                } else if (antiguedad >= 16 ) {
                    return (15);
                }
            case "SUV":
                if (antiguedad >= 0 && antiguedad <= 5) {
                    return (0);
                } else if (antiguedad >= 6 && antiguedad <= 10) {
                    return (7);
                } else if (antiguedad >= 11 && antiguedad <= 15) {
                    return (11);
                } else if (antiguedad >= 16 ) {
                    return (20);
                }
            case "PICKUP":
                if (antiguedad >= 0 && antiguedad <= 5) {
                    return (0);
                } else if (antiguedad >= 6 && antiguedad <= 10) {
                    return (7);
                } else if (antiguedad >= 11 && antiguedad <= 15) {
                    return (11);
                } else if (antiguedad >= 16 ) {
                    return (20);
                }
            case "FURGONETA":
                if (antiguedad >= 0 && antiguedad <= 5) {
                    return (0);
                } else if (antiguedad >= 6 && antiguedad <= 10) {
                    return (7);
                } else if (antiguedad >= 11 && antiguedad <= 15) {
                    return (11);
                } else if (antiguedad >= 16 ) {
                    return (20);
                }
        }
        return -1;
    }

    public Integer descuentoBono(String marca, String activacion){
        if(activacion.equals("true") ){
            if (marca.equals("TOYOTA") && cantToyota > 0) {
                return 70000;
            } else if (marca.equals("FORD") && cantFord > 0) {
                return 50000;
            } else if (marca.equals("HYUNDAI") && cantHyundai > 0) {
                return 30000;
            } else if (marca.equals("HONDA") && cantHonda > 0) {
                return 40000;
            }
        }
        else{
            return 0;
        }
        return -1;
    }

    public Integer descuentoNrep(Integer nrep, String tipoMotor){
        switch (tipoMotor){
            case "GASOLINA":
                if (nrep >= 1 && nrep <= 2){
                    return 5;
                }else if (nrep >= 3 && nrep <= 5){
                    return 10;
                }else if (nrep >= 6 && nrep <= 9){
                    return 15;
                }else if (nrep >= 10){
                    return 20;
                } else {
                    return 0;
                }

            case "DIESEL":
                if (nrep >= 1 && nrep <= 2){
                    return 7;
                }else if (nrep >= 3 && nrep <= 5){
                    return 12;
                }else if (nrep >= 6 && nrep <= 9){
                    return 17;
                }else if (nrep >= 10){
                    return 22;
                } else {
                    return 0;
                }
            case "HIBRIDO":
                if (nrep >= 1 && nrep <= 2){
                    return 10;
                }else if (nrep >= 3 && nrep <= 5){
                    return 15;
                }else if (nrep >= 6 && nrep <= 9){
                    return 20;
                }else if (nrep >= 10){
                    return 25;
                } else {
                    return 0;
                }
            case "ELECTRICO":
                if (nrep >= 1 && nrep <= 2){
                    return 8;
                }else if (nrep >= 3 && nrep <= 5){
                    return 13;
                }else if (nrep >= 6 && nrep <= 9){
                    return 18;
                }else if (nrep >= 10){
                    return 23;
                } else {
                    return 0;
                }
        }
        return -1;
    }

    public Integer descuentoDia(String fechaCompleta){
        //SABADO, 27-04-2024, 20:45:01
        //09:00 hrs y las 12:00 hrs.


        String[] parts = fechaCompleta.split(",");
        String dia = parts[0];
        String hora = parts[2];

        if ((dia.equals("LUNES") || dia.equals("JUEVES"))) {

            String[] partsHora = hora.split(":");
            String horaf = partsHora[0];
            String minutosf = partsHora[1];
            Integer hora_int = Integer.parseInt(horaf);
            Integer minutos_int = Integer.parseInt(minutosf);

            if ((hora_int >= 9 && hora_int <= 11) || (hora_int == 12 && minutos_int == 0)) {
                return 10;
            } else {
                return 0;
            }
        }else{
            return 0;
        }
    }

    public Float montoTotal(CostoEntity costoEntity){

        if(!costoEntity.getTipo_rep().isEmpty()) {
            Integer costotipo = 0;
            String[] tiposRep = costoEntity.getTipo_rep().split(",");
            Integer n_rep = reparacionService.reparaciondesc(costoEntity.getPatente(),costoEntity.getTipo_motor());

            for (int i = 0; i < tiposRep.length; i++) {
                Integer tipo_int = Integer.parseInt(tiposRep[i]);
                costotipo = costotipo + costoTipo(tipo_int,costoEntity.getTipo_motor(),costoEntity.getPatente(),false);
            }

            Integer recargokilometraje = costoKilometraje(costoEntity.getKilometraje(),costoEntity.getTipo_auto());
            Integer recargoantiguedad = costoAntiguedad(costoEntity.getAnio_fabricacion(),costoEntity.getTipo_auto());
            Integer descuentobono = descuentoBono(costoEntity.getMarca() , costoEntity.getActivacion());
            Integer descuentonrep = descuentoNrep(n_rep ,costoEntity.getTipo_motor());
            Integer descuentodia = descuentoDia(costoEntity.getFechaCompleta() );
            Float montoTotal = ((costotipo - descuentobono)*( 1 + ((recargokilometraje.floatValue() + recargoantiguedad.floatValue())/100) - ((descuentonrep.floatValue() + descuentodia.floatValue())/100)));

            return montoTotal;
        }

        return 0.0f;
    }

}
