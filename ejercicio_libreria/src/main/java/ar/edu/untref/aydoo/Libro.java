package ar.edu.untref.aydoo;

/**
 * Tipo de objeto: Value Object
 * */
public class Libro extends Producto{

    public Libro(double precio,String nombre) {
        super(nombre,precio);
    }

    public double getPrecio(){return this.precio;}
}
