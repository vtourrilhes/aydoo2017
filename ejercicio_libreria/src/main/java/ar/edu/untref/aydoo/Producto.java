package ar.edu.untref.aydoo;

/**
 * Created by Usuario on 02/04/2017.
 */
public class Producto {

    protected double precio;
    protected  String nombre;
    protected Periodicidad periodicidad;

    public Producto(String nombre,double precio,Periodicidad periodicidad){
        this.precio = precio;
        this.nombre = nombre;
        this.periodicidad = periodicidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre(){return  this.nombre;}

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }
}
