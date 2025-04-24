package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.LinkedList;

public class Soldado {
    private String idSoldado;
    private String nombreSoldado;
    private int edadSoldado;
    private boolean disponible;
    private Especialidad especialidad;
    private RangoMilitar rangoMilitar;


    public Soldado(String idSoldado, String nombreSoldado, int edadSoldado,boolean disponible,Especialidad especialidad,RangoMilitar rangoMilitar) {
        this.idSoldado = idSoldado;
        this.nombreSoldado = nombreSoldado;
        this.edadSoldado = edadSoldado;
        this.disponible = disponible;
        this.especialidad = especialidad;
        this.rangoMilitar = rangoMilitar;

    }



    public String getIdSoldado() {
        return idSoldado;
    }

    public void setIdSoldado(String idSoldado) {
        this.idSoldado = idSoldado;
    }

    public String getNombreSoldado() {
        return nombreSoldado;
    }

    public void setNombreSoldado(String nombreSoldado) {
        this.nombreSoldado = nombreSoldado;
    }

    public int getEdadSoldado() {
        return edadSoldado;
    }

    public void setEdadSoldado(int edadSoldado) {
        this.edadSoldado = edadSoldado;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public RangoMilitar getRangoMilitar() {
        return rangoMilitar;
    }

    public void setRangoMilitar(RangoMilitar rangoMilitar) {
        this.rangoMilitar = rangoMilitar;
    }

    @Override
    public String toString() {
        return "Soldado{" +
                "idSoldado='" + idSoldado + '\'' +
                ", nombreSoldado='" + nombreSoldado + '\'' +
                ", edadSoldado=" + edadSoldado +
                ", disponible=" + disponible +
                ", especialidad=" + especialidad +
                ", rangoMilitar=" + rangoMilitar +
                '}';
    }
}
