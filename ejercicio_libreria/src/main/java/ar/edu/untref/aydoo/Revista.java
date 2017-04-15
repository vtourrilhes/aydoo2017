package ar.edu.untref.aydoo;

/**
 * Tipo de objeto: Value Object
 * */
public class Revista extends Producto{

    private Suscripcion suscripcion;
    private boolean tieneSuscripcion;
    private Periodicidad periodicidad;

    public Revista(String nombre,double precio, Suscripcion suscripcion,Periodicidad periodicidad) {

        super(nombre,precio);
        this.tieneSuscripcion = true;
        this.suscripcion= suscripcion;
        this.periodicidad = periodicidad;
    }

    public Revista(String nombre,double precio,Periodicidad periodicidad) {

        super(nombre,precio);
        this.tieneSuscripcion = false;
        this.periodicidad = periodicidad;
    }

    public double getPrecio(){
        double respuesta;

        if(tieneSuscripcion){
            respuesta = this.precio * this.suscripcion.getPrecio() * periodicidad.getValor();
        }else{
            respuesta = this.precio;
        }

        return respuesta;
    }

}
