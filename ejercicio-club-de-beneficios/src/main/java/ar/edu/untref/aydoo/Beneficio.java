package ar.edu.untref.aydoo;

public abstract class Beneficio {

    protected Tarjeta tarjeta;

    public Beneficio(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Tarjeta getTarjeta(){
        return this.tarjeta;
    }

}
