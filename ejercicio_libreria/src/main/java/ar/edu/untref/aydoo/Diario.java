package ar.edu.untref.aydoo;

public class Diario  extends Producto {

    private Suscripcion suscripcion;
    private boolean tieneSuscripcion;
    private Periodicidad periodicidad;

    public Diario(String nombre,double precio,Suscripcion suscripcion,Periodicidad periodicidad) {
        super(nombre,precio);
        this.tieneSuscripcion = true;
        this.suscripcion = suscripcion;
        this.periodicidad = periodicidad;
    }

        public Diario(String nombre,double precio,Periodicidad periodicidad) {
            super(nombre,precio);
            this.tieneSuscripcion = false;
            this.periodicidad = periodicidad;
        }

    @Override
    public double getPrecio() {

        double respuesta ;

        if(tieneSuscripcion){
            respuesta = this.precio * this.suscripcion.getPrecio() * periodicidad.getValor();
        }else{
            respuesta = this.precio;
        }

        return respuesta;
    }

}
