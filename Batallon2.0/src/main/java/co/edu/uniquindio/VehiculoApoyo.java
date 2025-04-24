package co.edu.uniquindio;

public class VehiculoApoyo extends Vehiculo {
    private TipoFuncion tipoFuncion;

    public VehiculoApoyo(String id, String modelo, int anioFabricacion, double kilometraje, EstadoOperativo estadoOperativo, TipoFuncion tipoFuncion) {
        super(id, modelo, anioFabricacion, kilometraje, estadoOperativo);

        this.tipoFuncion = tipoFuncion;
    }

    @Override
    public void desplazar() {

    }


    public TipoFuncion getTipoFuncion() {
        return tipoFuncion;
    }

    public void setTipoFuncion(TipoFuncion tipoFuncion) {
        this.tipoFuncion = tipoFuncion;
    }

    @Override
    public String toString() {
        return "VehiculoApoyo{" +
                "tipoFuncion=" + tipoFuncion +
                ", id='" + id + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anioFabricacion=" + anioFabricacion +
                ", kilometraje=" + kilometraje +
                ", misionesCompletadas=" + misionesCompletadas +
                ", estadoOperativo=" + estadoOperativo +
                ", listMisiones=" + listMisiones +
                '}';
    }
}
