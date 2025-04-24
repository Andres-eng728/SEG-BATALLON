import co.edu.uniquindio.EstadoOperativo;
import co.edu.uniquindio.TipoFuncion;
import co.edu.uniquindio.VehiculoApoyo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehiculoApoyoTest {

    private VehiculoApoyo vehiculo;

    @BeforeEach
    void setUp() {
        vehiculo = new VehiculoApoyo("VA1", "ApoyoModelo", 2020, 1234.5, EstadoOperativo.DISPONIBLE, TipoFuncion.LOGISTICA);
    }

    @Test
    void testDatosIniciales() {
        assertEquals("VA1", vehiculo.getId());
        assertEquals("ApoyoModelo", vehiculo.getModelo());
        assertEquals(2020, vehiculo.getAnioFabricacion());
        assertEquals(1234.5, vehiculo.getKilometraje());
        assertEquals(EstadoOperativo.DISPONIBLE, vehiculo.getEstadoOperativo());
        assertEquals(TipoFuncion.LOGISTICA, vehiculo.getTipoFuncion());
    }

    @Test
    void testModificarFuncion() {
        vehiculo.setTipoFuncion(TipoFuncion.COMUNICACIONES);
        assertEquals(TipoFuncion.COMUNICACIONES, vehiculo.getTipoFuncion());
    }

    @Test
    void testToStringNotNull() {
        assertNotNull(vehiculo.toString());
    }
}

