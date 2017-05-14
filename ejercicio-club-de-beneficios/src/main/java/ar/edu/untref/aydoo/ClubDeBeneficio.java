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
        this.clientes.add(cliente);
        return new Cliente(nombre,email,tarjeta);


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

    public int enviarReporteDeAhorros(Mes mes){

        int reportesEnviados = 0;

        for (Cliente cliente: this.clientes){

            List<Venta> comprasCliente = this.getVentasPorCliente(cliente,mes);

            MailService.sendReporteCliente(cliente,mes,comprasCliente);

            reportesEnviados++;
        }

        return reportesEnviados;

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

    public Establecimiento felicitarEstablecimiento(Mes mes){

        Establecimiento ganador = null;
        int cantidadBeneficiosGanador = 0;

        for (Establecimiento establecimiento: this.establecimientos) {
            if(establecimiento.getCantidadBeneficiosOtorgadosPorMes(mes)>cantidadBeneficiosGanador) {
                ganador = establecimiento;
                cantidadBeneficiosGanador = establecimiento.getCantidadBeneficiosOtorgadosPorMes(mes);
            }
        }

        MailService.sendMailFelicitacionEstablecimiento(ganador);

        return ganador;
    }

    public Sucursal enviarRegaloMensualASucursal(Mes mes){

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

        MailService.sendMailFelicitacionSucursal(ganadora);

        return ganadora;

    }

}
