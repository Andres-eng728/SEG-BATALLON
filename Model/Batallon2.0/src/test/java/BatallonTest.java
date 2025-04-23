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
    Soldado s1 = new Soldado("13", "Martín", 25, true, Especialidad.COMUNICACIONES, RangoMilitar.SOLDADO);
    Soldado s2 = new Soldado("14", "Laura", 28, true, Especialidad.MEDICO, RangoMilitar.CABO);
    Soldado s3 = new Soldado("15", "Carlos", 30, true, Especialidad.LOGISTICA, RangoMilitar.CABO);
    Soldado s4 = new Soldado("16", "Ana", 22, true, Especialidad.MEDICO, RangoMilitar.SOLDADO);
    Soldado s5 = new Soldado("17", "Luis", 35, true, Especialidad.COMUNICACIONES, RangoMilitar.SARGENTO);




    @Test

    void testBuscarSoldadoPorId() {


        Batallon batallon= new Batallon("mali","1345");
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
        Batallon batallon = new Batallon("ff","13456");

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
        Batallon batallon = new Batallon("Batallón Test", "BT01");


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
        Batallon batallon =new Batallon("Batallon Test", "BT01");
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
    void testLiberarSoldado(){
        Batallon batallon  =new Batallon("Batallon Test", "BT01");

        Soldado soldado= new Soldado("S4","Jorge Niño",31,true,Especialidad.MEDICO,RangoMilitar.SARGENTO);
        batallon.agregarSoldado(soldado);

        Mision mision= new Mision("M2",LocalDate.now(),LocalDate.of(2025, 5, 1),LocalDate.of(2025, 5, 28), "Zona A");
        batallon.getListMisiones().add(mision);

        batallon.asignarSoldado("S4","M2");
        batallon.liberarSoldados();

        Assertions.assertTrue(soldado.isDisponible(),"El soldado deberia liberarse correctamente.");
        Assertions.assertTrue(mision.getlistPersonal().isEmpty(),"La lista deberia estar vacia.");;

    }

    @Test
    void testVehiculoMayorCantMisiones(){
        Batallon batallon  =new Batallon("Batallon Test", "BT01");
        VehiculoApoyo



    }

}


