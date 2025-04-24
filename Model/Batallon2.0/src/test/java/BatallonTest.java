import co.edu.uniquindio.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

class BatallonTest {
    private static final Logger LOG = Logger.getLogger(BatallonTest.class.getName());
    Batallon batallon = new Batallon("Batallón Central", "B001");
    
    @Test

    void testBuscarSoldadoPorId() {

        Soldado newSoldado = new Soldado("13","martin",25,true, Especialidad.COMUNICACIONES, RangoMilitar.SOLDADO);
        batallon.agregarSoldado(newSoldado);

        Soldado encontrado = Batallon.buscarSoldadoPorId(batallon.getListSoldados(), "13");
        assertNotNull(encontrado);
        assertEquals("13", encontrado.getIdSoldado());

        assertNull(Batallon.buscarSoldadoPorId(batallon.getListSoldados(), "XXX"));
    }

    @Test
    void testObtenerPromedioEdad() {
        List<Soldado> soldadosPrueba = new ArrayList<>();
        soldadosPrueba.add(new Soldado("13", "Martín", 25, true, Especialidad.COMUNICACIONES, RangoMilitar.SOLDADO));
        soldadosPrueba.add(new Soldado("14", "Laura", 28, true, Especialidad.MEDICO, RangoMilitar.CABO));
        soldadosPrueba.add(new Soldado("15", "Carlos", 30, true, Especialidad.LOGISTICA, RangoMilitar.SARGENTO));

        double promedio = Batallon.obtenerPromedioEdad(soldadosPrueba);
        System.out.println("Promedio de edad: " + promedio);
        assertEquals((25 + 30 + 28) / 3.0, promedio);
    }

    @Test
    public void testBuscarPorEspecialidad() {
        Soldado s1 = new Soldado("1", "Carlos", 25, true, Especialidad.COMUNICACIONES, RangoMilitar.SOLDADO);
        Soldado s2 = new Soldado("2", "Laura", 30, true, Especialidad.MEDICO, RangoMilitar.CABO);
        Soldado s3 = new Soldado("3", "Andrés", 27, true, Especialidad.COMUNICACIONES, RangoMilitar.SARGENTO);

        batallon.agregarSoldado(s1);
        batallon.agregarSoldado(s2);
        batallon.agregarSoldado(s3);

        LinkedList<Soldado> resultado = batallon.buscarPorEspecialidad(Especialidad.COMUNICACIONES);

        assertEquals(2, resultado.size());

        assertTrue(resultado.contains(s1));
        assertTrue(resultado.contains(s3));
        assertFalse(resultado.contains(s2));

    }

    @Test
    void testObtenerSoldadosDisponiblesPorRango() {
      
        batallon.agregarSoldado(new Soldado("10", "Carlos", 30, false, Especialidad.LOGISTICA, RangoMilitar.SARGENTO));
        batallon.agregarSoldado(new Soldado("11", "Laura", 28, true, Especialidad.MEDICO, RangoMilitar.CABO));
        batallon.agregarSoldado(new Soldado("17", "Luis", 35, true, Especialidad.COMUNICACIONES, RangoMilitar.SARGENTO));
        List<Soldado> sargentosDisponibles = batallon.obtenerSoldadosDisponiblesPorRango(RangoMilitar.SARGENTO);

        assertEquals(1, sargentosDisponibles.size());
        assertEquals("17", sargentosDisponibles.get(0).getIdSoldado());
    }
    @Test
    void testAgregarSoldadoYVerificarDuplicado() {
        Soldado nuevo = new Soldado("18", "Elena", 26, true, Especialidad.MEDICO, RangoMilitar.CABO);
        assertTrue(batallon.agregarSoldado(nuevo));
        assertFalse(batallon.agregarSoldado(nuevo)); // No debe poder agregarse dos veces
    }

    @Test
    void testAgregarYEliminarSoldado() {
        Soldado nuevo = new Soldado("S100", "Tar", 26,true, Especialidad.LOGISTICA, RangoMilitar.SARGENTO);
        assertTrue(batallon.agregarSoldado(nuevo));
        assertFalse(batallon.agregarSoldado(nuevo)); // Duplicado
        assertTrue(batallon.eliminarSoldado("S100"));
        assertFalse(batallon.eliminarSoldado("S100")); // Ya fue eliminado
    }

    @Test
    void testAsignarSoldado(){
        Soldado soldado = new Soldado("123", "Juan Zapata",29,true,Especialidad.MEDICO,RangoMilitar.SARGENTO);
        batallon.agregarSoldado(soldado);
        Mision mision= new Mision("M123",LocalDate.of(2025, 4, 1),LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 10), "Zona A");
        batallon.getListMisiones().add(mision);
        boolean resultado= batallon.asignarSoldado("123", "M123");
        
        Assertions.assertTrue(resultado,"El soldado deberia asignarse correctamente.");
        Assertions.assertFalse(soldado.isDisponible(),"El soldado deberia marcarse como no disponible.");

        resultado= batallon.asignarSoldado("123", "M123");
        Assertions.assertFalse(resultado,"No deberia ser posible asignar el soldado si ya no esta disponible.");
    }


    @Test
    void testLiberarSoldados() {
        Soldado soldado = new Soldado("S1", "Luis", 30, true, Especialidad.MEDICO, RangoMilitar.SOLDADO);
        batallon.agregarSoldado(soldado);
        Mision mision = new Mision("M1", LocalDate.now().minusDays(1), LocalDate.now().minusDays(5), LocalDate.now().minusDays(1), "Zona X");
        batallon.getListMisiones().add(mision);
        boolean asignado = batallon.asignarSoldado("S1", "M1");
        
        assertTrue(asignado);
        assertFalse(soldado.isDisponible()); // debe estar no disponible tras asignación

        batallon.liberarSoldados();
        assertTrue(soldado.isDisponible()); // debe estar disponible tras liberar
    }


    @Test
    void testVehiculoMayorCantMisiones(){
        VehiculoApoyo vehiculoApoyo=new VehiculoApoyo("VAV59G","ModeloA",2018,130000,EstadoOperativo.DISPONIBLE,TipoFuncion.LOGISTICA);
        VehiculoBlindado vehiculoBlindado=new VehiculoBlindado("VAV51G","ModeloB",2015,200000,EstadoOperativo.DISPONIBLE, 5);
        vehiculoApoyo.setMisionesCompletadas(50);
        vehiculoBlindado.setMisionesCompletadas(70);
        batallon.agregarVehiculoApoyo(vehiculoApoyo);
        batallon.agregarVehiculoBlindado(vehiculoBlindado);

        Vehiculo vehiculoMayorCantMisiones= batallon.vehiculoMayorCantMisiones();
        Assertions.assertEquals(vehiculoBlindado,vehiculoMayorCantMisiones,"El vehiculo con mas misiones deberia ser devuelto");

    }


    @Test
    void testeRgistrarMision() {

        Soldado soldado = new Soldado("S1", "Carlos", 29, true, Especialidad.COMUNICACIONES, RangoMilitar.SARGENTO);
        batallon.agregarSoldado(soldado);
        VehiculoApoyo vehiculo = new VehiculoApoyo("VA1", "ApoyoModelo", 2020, 1000, EstadoOperativo.DISPONIBLE, TipoFuncion.LOGISTICA);
        batallon.agregarVehiculoApoyo(vehiculo);
        LinkedList<Soldado> personal = new LinkedList<>();
        personal.add(soldado);

        boolean resultado = batallon.registrarMision(
                LocalDate.of(2025, 4, 1),
                LocalDate.of(2025, 4, 1),
                LocalDate.of(2025, 4, 5),
                "Base Norte",
                personal,
                "VA1"
        );

        assertFalse(resultado);
    }

    @Test
    void testFiltroMisionesUbiFechas() {
    
        Mision m1 = new Mision("M1", LocalDate.of(2025, 4, 1), LocalDate.of(2025, 3, 30), LocalDate.of(2025, 4, 3), "Zona A");
        Mision m2 = new Mision("M2", LocalDate.of(2025, 4, 5), LocalDate.of(2025, 4, 4), LocalDate.of(2025, 4, 6), "Zona B");
        Mision m3 = new Mision("M3", LocalDate.of(2025, 4, 7), LocalDate.of(2025, 4, 6), LocalDate.of(2025, 4, 10), "Zona A");

        batallon.getListMisiones().add(m1);
        batallon.getListMisiones().add(m2);
        batallon.getListMisiones().add(m3);

        LinkedList<Mision> misionesfiltradas = batallon.filtroMisionesUbiFechas("Zona A", LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 7));
        assertEquals(2, misionesfiltradas.size());
        assertEquals("M1", misionesfiltradas.get(0).getIdMision());
        assertEquals("M3", misionesfiltradas.get(1).getIdMision());
    }



}


