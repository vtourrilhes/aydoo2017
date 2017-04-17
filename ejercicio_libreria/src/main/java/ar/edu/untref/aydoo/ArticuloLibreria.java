package ar.edu.untref.aydoo;

/**
 * Tipo de objeto: Value Object
 * */
public class ArticuloLibreria extends Producto{

    private final double IVA;

    public ArticuloLibreria(String nombre, double precio) {
        super(nombre,precio);
        IVA = 0.21;
    }

    public double getPrecio(){
        return this.precio + this.precio * IVA;
    }
}
