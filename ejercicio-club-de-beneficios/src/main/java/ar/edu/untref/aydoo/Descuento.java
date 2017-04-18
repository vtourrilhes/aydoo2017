package ar.edu.untref.aydoo;

public class Descuento extends Beneficio{

    private double descuento;

    public Descuento(double descuento, Tarjeta tarjeta) {
        super(tarjeta);
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }
}
