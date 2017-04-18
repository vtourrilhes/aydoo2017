package ar.edu.untref.aydoo;

public class Venta {

    private Cliente cliente;
    private double monto;
    private double descuentoRealizado;
    private Sucursal sucursal;

    public Venta(Cliente cliente, double montoBruto, Sucursal sucursal) {
        this.cliente = cliente;
        this.sucursal = sucursal;
        double montoNeto = montoBruto;

        //reviso los beneficios del establecimiento
        for (Beneficio beneficio: sucursal.getEstablecimiento().getBeneficios()) {

            //si la tarjeta que tiene el cliente coincide con la tarjeta de algun beneficio, realizo el beneficio
            if(beneficio.getTarjeta().equals(cliente.getTarjeta())) {
                montoNeto = beneficio.aplicarPromocion(montoNeto);
            }
        }

        this.descuentoRealizado = montoBruto - montoNeto;
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
