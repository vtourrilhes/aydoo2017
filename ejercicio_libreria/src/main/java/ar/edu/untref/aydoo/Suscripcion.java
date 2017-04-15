package ar.edu.untref.aydoo;


/**
 * Tipo de objeto: Value Object
 * */
public class Suscripcion {

    private TipoSuscripcion modificadorPorSuscripcion;

    public Suscripcion(TipoSuscripcion tipoSuscripcion){
        this.modificadorPorSuscripcion= tipoSuscripcion;
    }

    public double getPrecio() {
        return  this.modificadorPorSuscripcion.getValor();
    }

}
