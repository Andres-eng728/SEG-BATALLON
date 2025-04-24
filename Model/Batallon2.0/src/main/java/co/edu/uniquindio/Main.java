package co.edu.uniquindio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

    Batallon batallon = new Batallon("Mali", "1345");


    VehiculoTransporteTropa vehiculoTropa1 = new VehiculoTransporteTropa("1001", "ModeloTropa1", 2005, 1000, EstadoOperativo.DISPONIBLE, 50);
    VehiculoBlindado vehiculoBlindado1 = new VehiculoBlindado("1002", "ModeloBlindado1", 2008, 1500, EstadoOperativo.EN_MANTENIMIENTO, 4);
    VehiculoApoyo vehiculoApoyo1 = new VehiculoApoyo("1003", "ModeloApoyo1", 2010, 2000, EstadoOperativo.EN_MANTENIMIENTO, TipoFuncion.LOGISTICA);

    batallon.agregarVehiculoTransporteTropa(vehiculoTropa1);
    batallon.agregarVehiculoBlindado(vehiculoBlindado1);
    batallon.agregarVehiculoApoyo(vehiculoApoyo1);

    
    Soldado soldado1 = new Soldado("S001", "Mat", 30, true, Especialidad.COMUNICACIONES, RangoMilitar.SOLDADO);
    Soldado soldado2 = new Soldado("S002", "Jackson", 25, true, Especialidad.MEDICO, RangoMilitar.SARGENTO);
    Soldado soldado3 = new Soldado("S003", "Melody", 22, true, Especialidad.LOGISTICA, RangoMilitar.CABO);
    Soldado soldado4 = new Soldado("S004", "Martin", 27, true, Especialidad.COMUNICACIONES, RangoMilitar.SOLDADO);

    batallon.agregarSoldado(soldado1);
    batallon.agregarSoldado(soldado2);
    batallon.agregarSoldado(soldado3);
    batallon.agregarSoldado(soldado4);

  
    Mision mision1 = new Mision("M01", LocalDate.of(2003, 4, 18), LocalDate.of(2003, 4, 19), LocalDate.of(2003, 5, 19), "Nigeria");
    mision1.getlistPersonal().add(soldado1);
    mision1.getlistPersonal().add(soldado3);
    mision1.setTheVehiculo(vehiculoApoyo1);  

    batallon.getListMisiones().add(mision1);          
    System.out.println(batallon);

    System.out.println("\n MISIONES REGISTRADAS ");
    for (Mision m : batallon.getListMisiones()) {
        System.out.println(m);
        System.out.println("   Vehículo: " + m.getTheVehiculo());
        System.out.println("   Personal asignado:");
        for (Soldado s : m.getlistPersonal()) {
            System.out.println("    - " + s);
            }
        }
    
 System.out.println("Resultado búsqueda por ID 'S003': " + batallon.buscarPorId("S003"));
 } 
}
