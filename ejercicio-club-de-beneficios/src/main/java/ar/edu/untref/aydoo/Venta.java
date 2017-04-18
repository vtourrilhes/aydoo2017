package ar.edu.untref.aydoo;

public class Venta {

    private Cliente cliente;
    private double monto;
    private double descuentoRealizado;
    private Sucursal sucursal;
    private Producto producto;

    public Venta(Cliente cliente, Producto producto, Sucursal sucursal) {
        this.cliente = cliente;
        this.sucursal = sucursal;
        double montoNeto = producto.getPrecio();
        this.producto = producto;

        //reviso los beneficios del establecimiento
        for (Beneficio beneficio: sucursal.getEstablecimiento().getBeneficios()) {

            //si la tarjeta que tiene el cliente coincide con la tarjeta de algun beneficio, realizo el beneficio
            if(beneficio.getTarjeta().equals(cliente.getTarjeta())) {
                montoNeto = beneficio.aplicarPromocion(montoNeto);
            }
        }

        this.descuentoRealizado = producto.getPrecio() - montoNeto;
        this.monto = montoNeto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getMonto() {
        return monto;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public double getDescuentoRealizado() {
        return descuentoRealizado;
    }
}
