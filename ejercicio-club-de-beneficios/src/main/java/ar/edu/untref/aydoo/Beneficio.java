package ar.edu.untref.aydoo;

public abstract class Beneficio {

    protected Tarjeta tarjeta;

    public Beneficio(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
        tarjeta.setBeneficio(this);
    }

    public Tarjeta getTarjeta(){
        return this.tarjeta;
    }

    public abstract double aplicarPromocion(double monto);
    public abstract double getDescuentoRealizado(double monto);
}
