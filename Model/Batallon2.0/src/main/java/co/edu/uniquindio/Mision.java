package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.LinkedList;

public class Mision {

    private String idMision;
    private LocalDate fecha;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String ubicacion;
    private Soldado soldado;
    private LinkedList<Soldado> listpersonal;

    private Vehiculo theVehiculo;

    public Mision(String id, LocalDate fecha,LocalDate fechaInicio,LocalDate fechaFin, String ubicacion) {
        this.idMision = id;
        this.fecha = fecha;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ubicacion = ubicacion;
        listpersonal = new LinkedList<>();

    }

    public String getIdMision() {
        return idMision;
    }

    public void setIdMision(String idMision) {
        this.idMision = idMision;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LinkedList<Soldado> getlistPersonal() {
        return listpersonal;
    }

    public void setlistPersonal(LinkedList<Soldado> personal) {
        this.listpersonal = personal;
    }

    public Vehiculo getTheVehiculo() {
        return theVehiculo;
    }

    public void setTheVehiculo(Vehiculo theVehiculo) {
        this.theVehiculo = theVehiculo;
    }

    @Override
    public String toString() {
        return "Mision{" +
                "idMision='" + idMision + '\'' +
                ", fecha=" + fecha +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", ubicacion='" + ubicacion + '\'' +
                ", soldado=" + soldado +
                ", listpersonal=" + listpersonal +
                ", theVehiculo=" + theVehiculo +
                '}';
    }
}
