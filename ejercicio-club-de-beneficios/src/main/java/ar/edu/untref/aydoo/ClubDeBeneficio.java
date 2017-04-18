package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class ClubDeBeneficio {

    private List<Establecimiento> establecimientos;
    private List<Cliente> clientes;

    public ClubDeBeneficio(){

        this.establecimientos = new LinkedList<>();
        this.clientes = new LinkedList<>();
    }

    public void addEstablecimiento(Establecimiento establecimiento) {
        this.establecimientos.add(establecimiento);
    }

    public Cliente addCliente(String nombre, String email, Tarjeta tarjeta) {

        Cliente cliente = new Cliente(nombre,email,tarjeta);

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

    public Sucursal getSucursalConMasBeneficiosOtorgados() {

        Sucursal ganadora = null;
        int ventasPorSucursal = 0;

        for (Establecimiento establecimiento: this.establecimientos) {
            for (Sucursal sucursal: establecimiento.getSucursales()) {
                if(sucursal.getBeneficiosOtorgados()>ventasPorSucursal){
                    ganadora = sucursal;
                    ventasPorSucursal = sucursal.getBeneficiosOtorgados();
                }
            }
        }

        return ganadora;


    }

    public double getMontoAhorradoPorCliente(Cliente cliente, Mes mes) {

        double resultado = 0;

        for (Establecimiento establecimiento: this.establecimientos) {

            resultado = resultado + establecimiento.getAhorroPorCliente(cliente,mes);

        }

        return resultado;
    }

    public void enviarReporteDeAhorros(){
        //TODO
   }

    public void felicitarEstablecimiento(){
        //TODO
    }

    public void enviarRegaloMensualASucursal(){
        //TODO
    }

}
