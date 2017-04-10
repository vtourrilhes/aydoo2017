package ar.edu.untref.aydoo;

public abstract class Producto {

    protected double precio;
    protected  String nombre;

    public Producto(String nombre,double precio){
        this.precio = precio;
        this.nombre = nombre;
    }

    public abstract double getPrecio();

    public String getNombre(){return  this.nombre;}

}
