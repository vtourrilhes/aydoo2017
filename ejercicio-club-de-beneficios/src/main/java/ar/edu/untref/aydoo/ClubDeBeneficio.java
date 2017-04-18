package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class ClubDeBeneficio {

    private List<Establecimiento> establecimientos;

    public ClubDeBeneficio(){
        this.establecimientos = new LinkedList<>();
    }

    public void addEstablecimiento(Establecimiento establecimiento) {
        this.establecimientos.add(establecimiento);
    }

    public Cliente addSuscripcion(String nombre, String email, Tarjeta tarjeta) {

        Cliente cliente = new Cliente(nombre,email);

        Suscripcion suscripcion = new Suscripcion(cliente,tarjeta);

        return cliente;

    }

    public Establecimiento getEstablecimientoConMasBeneficiosOtorgados() {

        Establecimiento ganador = null;
        int cantidadBeneficiosGanador = 0;

        for (Establecimiento establecimiento: establecimientos) {
            if(establecimiento.getCantidadBeneficiosOtorgados()>cantidadBeneficiosGanador) {
                cantidadBeneficiosGanador = establecimiento.getCantidadBeneficiosOtorgados();
                ganador = establecimiento;
            }
        }

        return ganador;
    }
}
