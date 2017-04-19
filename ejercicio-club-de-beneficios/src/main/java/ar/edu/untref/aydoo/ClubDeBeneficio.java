package ar.edu.untref.aydoo;

import java.util.HashMap;
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

    public void enviarReporteDeAhorros(Mes mes){

        //por cada cliente
        for (Cliente cliente: this.clientes){

            //obtengo las ventas en ese mes de ese cliente
            List<Venta> comprasCliente = this.getVentasPorCliente(cliente,mes);

            //envio el reporte al mailService(el reporte se procesa en mail service con la lista de ventas)
            MailService.sendReporteCliente(cliente,mes,comprasCliente);

        }

   }

    private List<Venta> getVentasPorCliente(Cliente cliente, Mes mes) {

        List<Venta> comprasClientePorMes = new LinkedList<>();

        for (Establecimiento establecimiento: this.establecimientos) {

            for (Sucursal sucursal: establecimiento.getSucursales()) {

                comprasClientePorMes.addAll(sucursal.getVentasPorMesCliente(cliente,mes));

            }

        }

        return comprasClientePorMes;
    }

    public String felicitarEstablecimiento(Mes mes){

        //busco el establecimiento ganador
        Establecimiento ganador = null;
        int cantidadBeneficiosGanador = 0;

        for (Establecimiento establecimiento: this.establecimientos) {
            if(establecimiento.getCantidadBeneficiosOtorgadosPorMes(mes)>cantidadBeneficiosGanador) {
                ganador = establecimiento;
                cantidadBeneficiosGanador = establecimiento.getCantidadBeneficiosOtorgadosPorMes(mes);
            }
        }

        //envio el mail
        return MailService.sendMailFelicitacionEstablecimiento(ganador);

    }

    public String enviarRegaloMensualASucursal(Mes mes){

        //busco el establecimiento ganador
        Sucursal ganadora = null;
        int cantidadClientesAtendidos = 0;

        for (Establecimiento establecimiento: this.establecimientos) {
            for (Sucursal sucursal: establecimiento.getSucursales()) {
                if(sucursal.getCantidadClientesAtendidos(mes)>cantidadClientesAtendidos) {
                    cantidadClientesAtendidos = sucursal.getCantidadClientesAtendidos(mes);
                    ganadora = sucursal;
                }
            }
        }

        //envio el mail
        return MailService.sendMailFelicitacionSucursal(ganadora);

    }

}
