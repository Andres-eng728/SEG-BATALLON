import co.edu.uniquindio.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MisionTest {
    private Mision mision;

    @BeforeEach
    void setUp() {
        mision = new Mision("M1", LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 10), "Zona A");
    }

    @Test
    void testDatosIniciales() {
        assertEquals("M1", mision.getIdMision());
        assertEquals("Zona A", mision.getUbicacion());
        assertEquals(LocalDate.of(2025, 4, 1), mision.getFecha());
        assertEquals(LocalDate.of(2025, 4, 1), mision.getFechaInicio());
        assertEquals(LocalDate.of(2025, 4, 10), mision.getFechaFin());
    }

    @Test
    void testAsignarPersonal() {
        Soldado s = new Soldado("S2", "Maria", 28, true, Especialidad.LOGISTICA, RangoMilitar.SARGENTO);
        LinkedList<Soldado> personal = new LinkedList<>();
        personal.add(s);
        mision.setlistPersonal(personal);
        assertEquals(1, mision.getlistPersonal().size());
        assertEquals("S2", mision.getlistPersonal().get(0).getIdSoldado());
    }

    @Test
    void testAsignarVehiculo() {
        VehiculoBlindado vb = new VehiculoBlindado("VB1", "BlindadoX", 2022, 1000.0, EstadoOperativo.DISPONIBLE, 4);
        mision.setTheVehiculo(vb);
        assertNotNull(mision.getTheVehiculo());
        assertEquals("VB1", mision.getTheVehiculo().getId());
    }

    @Test
    void testToStringNotNull() {
        assertNotNull(mision.toString());
    }
}
