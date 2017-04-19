package ar.edu.untref.aydoo;

public class Venta {

    private Cliente cliente;
    private double monto;
    private double descuentoRealizado;
    private Sucursal sucursal;
    private Producto producto;
    private Mes mes;

    public Venta(Cliente cliente, Producto producto, Sucursal sucursal,Mes mes) {
        this.cliente = cliente;
        this.sucursal = sucursal;
        double montoNeto = producto.getPrecio();
        this.producto = producto;
        this.mes = mes;

        //reviso los beneficios del establecimiento
        for (Beneficio beneficio: sucursal.getEstablecimiento().getBeneficios()) {

            //si la tarjeta que tiene el cliente coincide con la tarjeta de algun beneficio, realizo el beneficio
            if(beneficio.getTarjeta().equals(cliente.getTarjeta())) {

                this.descuentoRealizado = beneficio.getDescuentoRealizado(montoNeto);

                montoNeto = beneficio.aplicarPromocion(montoNeto);

            }
        }

        this.monto = montoNeto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Mes getMes() {
        return mes;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public double getDescuentoRealizado() {
        return descuentoRealizado;
    }

}
