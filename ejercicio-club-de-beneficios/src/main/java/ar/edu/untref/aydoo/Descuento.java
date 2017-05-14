package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.Exception.DescuentoInvalidoException;

public class Descuento extends Beneficio{

    public static final int PORCENTAJE_TOTAL = 100;
    public static final int DSCUENTO_MINIMO_NECESARIO = 5;

    private double descuento;

    public Descuento(double descuento, Tarjeta tarjeta) throws DescuentoInvalidoException {

        super(tarjeta);
        if(descuento< DSCUENTO_MINIMO_NECESARIO){
            throw new DescuentoInvalidoException();
        }
        this.descuento = descuento;
    }

    @Override
    public double aplicarPromocion(double monto) {
       return monto * ( 1- descuento / PORCENTAJE_TOTAL);
    }

    @Override
    public double getDescuentoRealizado(double monto) {
        return monto - (monto * ( 1- descuento / PORCENTAJE_TOTAL ));
    }
}
