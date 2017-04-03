package ar.edu.untref.aydoo;


public class Libro extends Producto{

    public Libro(double precio,String nombre) {
        super(nombre,precio,Periodicidad.SIN_PERIODICIDAD);
    }
}
