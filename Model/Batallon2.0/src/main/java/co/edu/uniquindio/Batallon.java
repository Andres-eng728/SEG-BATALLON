package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.*;

public class Batallon {
    private String nombre;
    private String id;
    private LinkedList<VehiculoApoyo> listVehiculosApoyo;
    private LinkedList<VehiculoBlindado> listVehiculosBlindados;
    private LinkedList<VehiculoTransporteTropa> listVehiculosTransporteTropa;
    private LinkedList<Soldado>listSoldados;
    private LinkedList<Mision> listMisiones;
    private LinkedList<Soldado> listpersonal;


    public Batallon(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.listVehiculosApoyo = new LinkedList<>();
        this.listVehiculosBlindados = new LinkedList<>();
        this.listVehiculosTransporteTropa = new LinkedList<>();
        this.listMisiones = new LinkedList<>();
        this.listpersonal = new LinkedList<>();
        this.listSoldados = new LinkedList<>();
    }

    public LinkedList<Vehiculo> obtenerVehiculosCantMisiones() {
        LinkedList<Vehiculo> vehiculosMisionesCompletadas = new LinkedList<>();

        for (VehiculoApoyo vehiculo : listVehiculosApoyo) {
            if (vehiculo.getMisionesCompletadas() > 50){
                vehiculosMisionesCompletadas.add(vehiculo);
            }
        }

        for(VehiculoBlindado vehiculo : listVehiculosBlindados){
            if (vehiculo.getMisionesCompletadas() > 50){
                vehiculosMisionesCompletadas.add(vehiculo);
            }
        }

        for(VehiculoTransporteTropa vehiculo : listVehiculosTransporteTropa){
            if (vehiculo.getMisionesCompletadas() > 50){
                vehiculosMisionesCompletadas.add(vehiculo);
            }
        }

        return vehiculosMisionesCompletadas;
    }
    
    public boolean registrarMision(LocalDate fecha, LocalDate fechaInicio, LocalDate fechafin, String ubicacion, LinkedList<Soldado> listPersonal, String idVehiculoMision ){
        boolean flag = false;
        String cantidadMisiones =String.valueOf(listMisiones.size()+1);
        Mision newMision = new Mision(cantidadMisiones,fecha,fechaInicio,fechafin,ubicacion);
        for (VehiculoApoyo vehiculoApoyo : listVehiculosApoyo) {
            if (idVehiculoMision.equals(vehiculoApoyo.getId())){
                int misionesCompletadas = vehiculoApoyo.getMisionesCompletadas();
                vehiculoApoyo.setMisionesCompletadas(misionesCompletadas + 1);

            }
        }
        return   flag;
}

    public LinkedList<Mision> filtroMisionesUbiFechas(String ubicacion, LocalDate fechaInicio, LocalDate fechaFin) {
        LinkedList<Mision> misionesFiltro = new LinkedList<>();
        for (Mision i : listMisiones) {
            if (i.getUbicacion().equals(ubicacion) && ((i.getFecha().isEqual(fechaInicio) || i.getFecha().
                    isAfter(fechaInicio)) && (i.getFecha().isEqual(fechaFin) || i.getFecha().isBefore(fechaFin)))) {
                misionesFiltro.add(i);
            }

        }
        return misionesFiltro;
    }

    public double kilometrajePromedioTropas (){
        double sumaTropas = 0;
        double promedioTropas = 0;
        for(VehiculoTransporteTropa newTransporteTropas : listVehiculosTransporteTropa){
            sumaTropas = newTransporteTropas.getKilometraje()+sumaTropas;
        }
        promedioTropas = sumaTropas/listVehiculosTransporteTropa.size();
        return promedioTropas;

    }

    public double kilometrajePromedioApoyo(){
        double sumaApoyos = 0;
        double promedioApoyos = 0;
        for(VehiculoApoyo newApoyo : listVehiculosApoyo){
            sumaApoyos = newApoyo.getKilometraje()+sumaApoyos;
        }
        promedioApoyos = sumaApoyos/listVehiculosApoyo.size();
        return promedioApoyos;
    }

    public double kilometrajePromedioBlindado(){
        double sumaBlindados = 0;
        double promedioBlindados = 0;
        for(VehiculoBlindado newBlindado : listVehiculosBlindados){
            sumaBlindados = newBlindado.getKilometraje()+sumaBlindados;
        }

        promedioBlindados = sumaBlindados/listVehiculosBlindados.size();
        return promedioBlindados;
    }

    public Vehiculo vehiculoMayorCantMisiones(){
        Vehiculo vehiculoMaxCantMisiones = null;
        int maxCantMisiones = 0;
        for (Vehiculo vehiculoApoyo : listVehiculosApoyo) {
            if (vehiculoApoyo.getMisionesCompletadas() > maxCantMisiones) {
                maxCantMisiones = vehiculoApoyo.getMisionesCompletadas();
                vehiculoMaxCantMisiones = vehiculoApoyo;
            }
        }for (Vehiculo vehiculoBlindado : listVehiculosBlindados) {
            if (vehiculoBlindado.getMisionesCompletadas() > maxCantMisiones) {
                maxCantMisiones = vehiculoBlindado.getMisionesCompletadas();
                vehiculoMaxCantMisiones = vehiculoBlindado;
            }
        }for (VehiculoTransporteTropa transporteTropas : listVehiculosTransporteTropa) {
            if(transporteTropas.getMisionesCompletadas() > maxCantMisiones){
                maxCantMisiones = transporteTropas.getMisionesCompletadas();
                vehiculoMaxCantMisiones = transporteTropas;
            }
        }
        return vehiculoMaxCantMisiones;
    }

    public boolean verficarVehiculoBlindado(String id) {
        for (VehiculoBlindado vehiculoBlindado : listVehiculosBlindados) {
            if (getId().equals(vehiculoBlindado.getId())) {
                return false;
            }
        }
        return true;
    }

    public boolean agregarVehiculoBlindado(VehiculoBlindado vehiculoBlindado) {
       boolean centinela = false;
        if(verficarVehiculoBlindado(vehiculoBlindado.getId())){
            listVehiculosBlindados.add(vehiculoBlindado);
            centinela = true;
        }
        return centinela;

    }

    public boolean eliminarVehiculoBlindado(String id) {
        boolean centinela = false;
        for(VehiculoBlindado vehiculoBlindado : listVehiculosBlindados) {
            if (getId().equals(vehiculoBlindado.getId())) {
                listVehiculosBlindados.remove(vehiculoBlindado);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarVehiculoTransporteTropa(String id) {
        for (VehiculoTransporteTropa vehiculo : listVehiculosTransporteTropa) {
            if (vehiculo.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public boolean agregarVehiculoTransporteTropa(VehiculoTransporteTropa vehiculo) {
        boolean centinela = false;
        if (verificarVehiculoTransporteTropa(vehiculo.getId())) {
            listVehiculosTransporteTropa.add(vehiculo);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarVehiculoTransporteTropa(String id) {
        boolean centinela = false;
        for (VehiculoTransporteTropa vehiculo : listVehiculosTransporteTropa) {
            if (vehiculo.getId().equals(id)) {
                listVehiculosTransporteTropa.remove(vehiculo);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarVehiculoApoyo(String id) {
        for (VehiculoApoyo vehiculo : listVehiculosApoyo) {
            if (vehiculo.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public boolean agregarVehiculoApoyo(VehiculoApoyo vehiculo) {
        boolean centinela = false;
        if (verificarVehiculoApoyo(vehiculo.getId())) {
            listVehiculosApoyo.add(vehiculo);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarVehiculoApoyo(String id) {
        boolean centinela = false;
        for (VehiculoApoyo vehiculo : listVehiculosApoyo) {
            if (vehiculo.getId().equals(id)) {
                listVehiculosApoyo.remove(vehiculo);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarSoldado(String id) {
        for (Soldado soldado : listSoldados) {
            if (soldado.getIdSoldado().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public boolean agregarSoldado(Soldado soldado) {
        boolean centinela = false;
        if(verificarSoldado(soldado.getIdSoldado())){
            listSoldados.add(soldado);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarSoldado(String id) {
        boolean centinela = false;
        for (Soldado soldado : listSoldados) {
            if (soldado.getIdSoldado().equals(id)) {
                listSoldados.remove(soldado);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public Soldado buscarPorId(String id) {
        for (Soldado soldado : listSoldados) {
            if (soldado.getIdSoldado().equals(id)) {
                return soldado;
            }
        }
        return null;
    }

    private Mision buscarMisionPorId(String idMision) {
        for (Mision mision : listMisiones) {
            if (mision.getIdMision().equals(idMision)) {
                return mision;
            }
        }
        return null;
    }

    public boolean asignarSoldado(String idSoldado, String idMision) {
        Soldado soldado = buscarPorId(idSoldado);
        Mision mision = buscarMisionPorId(idMision);

        if (soldado != null && mision != null && soldado.isDisponible()) {
            mision.getlistPersonal().add(soldado);
            soldado.setDisponible(false);
            return true;
        }
        return false;
    }

    public void liberarSoldados() {
        LocalDate hoy = LocalDate.now();

        for (Mision mision : listMisiones) {
            if (mision.getFecha().isBefore(hoy)) {
                for (Soldado soldado : mision.getlistPersonal()) {
                    soldado.setDisponible(true);
                }
            }
        }
    }

    public LinkedList<Soldado> buscarPorEspecialidad(Especialidad especialidad) {
        LinkedList<Soldado> resultado = new LinkedList<>();
        for (Soldado soldado : listSoldados) {
            if (soldado.getEspecialidad() == especialidad) {
                resultado.add(soldado);
            }
        }
        return resultado;
    }


    public List<Soldado> obtenerSoldadosDisponiblesPorRango(RangoMilitar rangoBuscado) {
        List<Soldado> resultado = new ArrayList<>();

        for (Soldado soldado : listSoldados) {
            if (soldado.isDisponible() && soldado.getRangoMilitar() == rangoBuscado) {
                resultado.add(soldado);
            }
        }

        return resultado;
    }

    public static double obtenerPromedioEdad(List<Soldado> listSoldados) {
        if (listSoldados == null || listSoldados.isEmpty()) {
            return 0.0; // o lanzar una excepción según el caso
        }

        int sumaEdades = 0;
        for (Soldado s : listSoldados) {
            sumaEdades += s.getEdadSoldado();
        }

        return (double) sumaEdades / listSoldados.size();
    }

    public static Soldado buscarSoldadoPorId(List<Soldado> listSoldados, String idBuscado) {
        for (Soldado s : listSoldados) {
            if (s.getIdSoldado().equals(idBuscado)) {
                return s;
            }
        }
        return null;
    }


    public LinkedList<Soldado> getListSoldados() {
        return listSoldados;
    }

    public void setListSoldados(LinkedList<Soldado> listSoldados) {
        this.listSoldados = listSoldados;
    }

    public LinkedList<Soldado> getListpersonal() {
        return listpersonal;
    }

    public void setListpersonal(LinkedList<Soldado> listpersonal) {
        this.listpersonal = listpersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinkedList<VehiculoApoyo> getListVehiculosApoyo() {
        return listVehiculosApoyo;
    }

    public void setListVehiculosApoyo(LinkedList<VehiculoApoyo> listVehiculosApoyo) {
        this.listVehiculosApoyo = listVehiculosApoyo;
    }

    public LinkedList<VehiculoBlindado> getListVehiculosBlindados() {
        return listVehiculosBlindados;
    }

    public void setListVehiculosBlindados(LinkedList<VehiculoBlindado> listVehiculosBlindados) {
        this.listVehiculosBlindados = listVehiculosBlindados;
    }

    public LinkedList<VehiculoTransporteTropa> getListVehiculosTransporteTropa() {
        return listVehiculosTransporteTropa;
    }

    public void setListVehiculosTransporteTropa(LinkedList<VehiculoTransporteTropa> listVehiculosTransporteTropa) {
        this.listVehiculosTransporteTropa = listVehiculosTransporteTropa;
    }

    public LinkedList<Mision> getListMisiones() {
        return listMisiones;
    }

    public void setListMisiones(LinkedList<Mision> listMisiones) {
        this.listMisiones = listMisiones;
    }

    @Override
    public String toString() {
        return "Batallon{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", listVehiculosApoyo=" + listVehiculosApoyo +
                ", listVehiculosBlindados=" + listVehiculosBlindados +
                ", listVehiculosTransporteTropa=" + listVehiculosTransporteTropa +
                ", listSoldados=" + listSoldados +
                ", listMisiones=" + listMisiones +
                ", listpersonal=" + listpersonal +
                '}';
    }
}
