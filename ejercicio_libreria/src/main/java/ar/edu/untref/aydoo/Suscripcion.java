package ar.edu.untref.aydoo;

public class Suscripcion {

    private TipoSuscripcion modificadorPorSuscripcion;

    public Suscripcion(TipoSuscripcion tipoSuscripcion){
        this.modificadorPorSuscripcion= tipoSuscripcion;
    }

    public double getPrecio() {
        return  this.modificadorPorSuscripcion.getValor();
    }

}
