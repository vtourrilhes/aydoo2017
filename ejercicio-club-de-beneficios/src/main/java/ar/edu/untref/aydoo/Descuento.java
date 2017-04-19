package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.Exception.DescuentoInvalidoException;

public class Descuento extends Beneficio{

    private double descuento;

    public Descuento(double descuento, Tarjeta tarjeta) throws DescuentoInvalidoException {

        super(tarjeta);
        if(descuento<5){
            throw new DescuentoInvalidoException();
        }
        this.descuento = descuento;
    }

    @Override
    public double aplicarPromocion(double monto) {
       return monto * ( 1- descuento / 100 );
    }

    @Override
    public double getDescuentoRealizado(double monto) {
        return monto - (monto * ( 1- descuento / 100 ));
    }
}
