import co.edu.uniquindio.EstadoOperativo;
import co.edu.uniquindio.VehiculoTransporteTropa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTransporteTropaTest {

    private VehiculoTransporteTropa vehiculo;

    @BeforeEach
    void setUp() {
        vehiculo = new VehiculoTransporteTropa("VT1", "TropaModelo", 2019, 1500.0, EstadoOperativo.DISPONIBLE, 25);
    }

    @Test
    void testDatosIniciales() {
        assertEquals("VT1", vehiculo.getId());
        assertEquals("TropaModelo", vehiculo.getModelo());
        assertEquals(2019, vehiculo.getAnioFabricacion());
        assertEquals(1500.0, vehiculo.getKilometraje());
        assertEquals(EstadoOperativo.DISPONIBLE, vehiculo.getEstadoOperativo());
        assertEquals(25, vehiculo.getCapacidadSoldados());
    }

    @Test
    void testCambiarCapacidadSoldados() {
        vehiculo.setCapacidadSoldados(30);
        assertEquals(30, vehiculo.getCapacidadSoldados());
    }

    @Test
    void testToStringNotNull() {
        assertNotNull(vehiculo.toString());
    }
}

