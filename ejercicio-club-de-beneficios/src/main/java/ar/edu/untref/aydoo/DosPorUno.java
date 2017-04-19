package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.Exception.DosPorUnoInvalidoException;

public class DosPorUno extends Beneficio{

    private Producto productoPrecioMayor;
    private Producto productoPrecioMenor;

    public DosPorUno(Tarjeta tarjeta) {
        super(tarjeta);
    }

    public void setProductos(Producto p1,Producto p2) throws DosPorUnoInvalidoException {

        if(p1.getPrecio()<100 && p2.getPrecio() <100){
            throw new DosPorUnoInvalidoException();
        }

        if(p1.getPrecio()>p2.getPrecio()) {
            this.productoPrecioMayor = p1;
            this.productoPrecioMenor = p2;
        }else {
            this.productoPrecioMayor = p2;
            this.productoPrecioMenor = p1;
        }
    }

    @Override
    public double aplicarPromocion(double monto) {
        return productoPrecioMayor.getPrecio();
    }

    @Override
    public double getDescuentoRealizado(double monto) {
        return productoPrecioMenor.getPrecio();
    }

}
