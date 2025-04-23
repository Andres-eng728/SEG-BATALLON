import co.edu.uniquindio.EstadoOperativo;
import co.edu.uniquindio.VehiculoBlindado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehiculoBlindadoTest {

    private VehiculoBlindado vehiculo;

    @BeforeEach
    void setUp() {
        vehiculo = new VehiculoBlindado("VB1", "Blindado2020", 2020, 3000.0, EstadoOperativo.DISPONIBLE, 5);
    }

    @Test
    void testDatosIniciales() {
        assertEquals("VB1", vehiculo.getId());
        assertEquals("Blindado2020", vehiculo.getModelo());
        assertEquals(2020, vehiculo.getAnioFabricacion());
        assertEquals(3000.0, vehiculo.getKilometraje());
        assertEquals(EstadoOperativo.DISPONIBLE, vehiculo.getEstadoOperativo());
        assertEquals(5, vehiculo.getNivelBlindaje());
    }

    @Test
    void testCambiarNivelBlindaje() {
        vehiculo.setNivelBlindaje(10);
        assertEquals(10, vehiculo.getNivelBlindaje());
    }

    @Test
    void testToStringNotNull() {
        assertNotNull(vehiculo.toString());
    }
}
