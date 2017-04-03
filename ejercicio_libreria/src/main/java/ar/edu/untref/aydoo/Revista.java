package ar.edu.untref.aydoo;

public class Revista extends Producto{

    public Revista(String nombre,double precio, Periodicidad periodicidad) {
        super(nombre,precio,periodicidad);
    }

    public void setPeriodicidad(Periodicidad periodicidad){
        super.periodicidad = periodicidad;
    }

}
