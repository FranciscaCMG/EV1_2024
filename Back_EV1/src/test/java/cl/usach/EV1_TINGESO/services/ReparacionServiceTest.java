package cl.usach.EV1_TINGESO.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ReparacionServiceTest {

    @Autowired
    ReparacionService reparacionService;

    @Test
    void obtenerReparacion() {
        assertNotNull(reparacionService.obtenerReparacion());
    }

    @Test
    void obtenerReparacionPorPatente() {
        assertNotNull(reparacionService.obtenerReparacionPorPatente("RZJP77"));
    }

    @Test
    void obtenerReparacionPorId() {
        assertNotNull(reparacionService.obtenerReparacionPorId("1"));
    }

    @Test
    void reparaciondesc() {
        assertNotNull(reparacionService.reparaciondesc("RZJP77", "DISEL"));
        assertAll(() -> assertEquals(reparacionService.reparaciondesc("RZJP77", "GASOLINA"),10),
                  () -> assertNotNull(reparacionService.reparaciondesc("RZJP77", "GASOLINA")));
    }

    @Test
    void modificarReparacionListo() {
        assertNotNull(reparacionService.modificarReparacionListo("1", "2021-06-01", "14:38:08"));
    }

    @Test
    void calcularDiasTranscurridos() {

        assertAll(() -> assertEquals(reparacionService.calcularDiasTranscurridos("01-06-2024", "02-06-2024"),1),
                  () -> assertEquals(reparacionService.calcularDiasTranscurridos("01-06-2024", "07-06-2024"),6));
    }

    @Test
    void modificarReparacionSalida() {
    }

    @Test
    void tablaR2() {
    }

    @Test
    void tablaR4() {
    }
}