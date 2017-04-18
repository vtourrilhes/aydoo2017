package ar.edu.untref.aydoo;

public class Venta {

    private Cliente cliente;
    private double monto;

    public Cliente getCliente() {
        return cliente;
    }

    public double getMonto() {
        return monto;
    }

    public Venta(Cliente cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }
}
