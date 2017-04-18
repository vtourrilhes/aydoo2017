package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String email;
    private Tarjeta tarjeta;
    private List<Beneficio> beneficios;

    public Cliente(String nombre, String email,Tarjeta tarjeta) {
        this.nombre = nombre;
        this.email = email;
        this.tarjeta = tarjeta;
        this.beneficios = new LinkedList<>();
    }

    public void addBeneficio(Beneficio beneficio){
        this.beneficios.add(beneficio);
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
