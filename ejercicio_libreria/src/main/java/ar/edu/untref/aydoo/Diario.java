package ar.edu.untref.aydoo;

public class Diario  extends Producto {

    public Diario(String nombre,double precio) {
        super(nombre,precio,Periodicidad.DIARIO);
    }

    public void setPeriodicidad(Periodicidad periodicidad){
        super.periodicidad = periodicidad;
    }

}
