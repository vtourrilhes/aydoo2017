package ar.edu.untref.aydoo;

public class Suscripcion {

    private Cliente cliente;
    private Tarjeta tarjeta;

    public Suscripcion(Cliente cliente, Tarjeta tarjeta) {
        this.cliente = cliente;
        this.cliente.setSuscripcion(this);
        this.tarjeta = tarjeta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }
}
