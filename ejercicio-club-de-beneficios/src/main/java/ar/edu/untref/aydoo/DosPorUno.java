package ar.edu.untref.aydoo;

public class DosPorUno extends Beneficio{

    private Producto productoPrecioMayor;
    private Producto productoPrecioMenor;

    public DosPorUno(Tarjeta tarjeta) {
        super(tarjeta);
    }

    public void setProductos(Producto p1,Producto p2){
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
