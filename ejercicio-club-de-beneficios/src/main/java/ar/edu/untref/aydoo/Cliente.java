package ar.edu.untref.aydoo;

public class Cliente {

    private String nombre;
    private String email;
    private Suscripcion suscripcion;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }
}
