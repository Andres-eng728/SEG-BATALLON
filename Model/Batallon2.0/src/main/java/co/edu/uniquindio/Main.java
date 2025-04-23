package co.edu.uniquindio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Batallon batallon= new Batallon("mali","1345");

    VehiculoTransporteTropa newVehiculo = new VehiculoTransporteTropa("1002",
                "2005", 2000, 100,EstadoOperativo.DISPONIBLE,100);

        VehiculoTransporteTropa newVehiculo2 = new VehiculoTransporteTropa("1001",
                "2005", 2000, 100, EstadoOperativo.DISPONIBLE,100);
        VehiculoApoyo newVehiculo3 = new VehiculoApoyo("1003","2006",2000,2000.0,EstadoOperativo.EN_MANTENIMIENTO,TipoFuncion.LOGISTICA);
        Mision mision1 = new Mision("14",LocalDate.of(2003,04,18),LocalDate.of(2003,04,19),LocalDate.of(2003,05,19),"nigeria");

        Soldado soldado1 =new Soldado("S001", "mat", 30,true ,Especialidad.COMUNICACIONES, RangoMilitar.SOLDADO);
        Soldado newSoldado = new Soldado("13","martin",25,true, Especialidad.COMUNICACIONES, RangoMilitar.SOLDADO);
        Soldado soldado3=new Soldado("S003", "melody", 22, true,Especialidad.LOGISTICA, RangoMilitar.CABO);
        Soldado soldado2= new Soldado("S002", "jackson", 25, true,Especialidad.MEDICO, RangoMilitar.SARGENTO);


        batallon.agregarVehiculoApoyo(newVehiculo3);
        batallon.agregarVehiculoTransporteTropa(newVehiculo2);
        batallon.agregarVehiculoTransporteTropa(newVehiculo);
        batallon.registrarMision(LocalDate.of(2003,04,18),LocalDate.of(2003,04,19),LocalDate.of(2003,05,19),"nigeria",mision1.getlistPersonal(),"1003");



        batallon.agregarSoldado(newSoldado);
        batallon.agregarSoldado(soldado1);
        batallon.agregarSoldado(soldado2);
        batallon.agregarSoldado(soldado3);

        System.out.println(batallon);

        System.out.println(batallon.buscarPorId("S003"));
    }




}