package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Establecimiento {

    private String nombre;
    private String mail;
    private List<Beneficio> beneficios;
    private List<Sucursal> sucursales;

    public Establecimiento(String nombre, String mail) {
        this.nombre = nombre;
        this.mail = mail;
        this.beneficios = new LinkedList<>();
        this.sucursales = new LinkedList<>();
    }

    public void addBeneficio(Beneficio beneficio) {
        this.beneficios.add(beneficio);
    }

    public List<Beneficio> getBeneficios() {
        return beneficios;
    }

    public int getCantidadBeneficiosOtorgados() {

        int cantidadTotalBeneficiosOtorgados = 0;

        for (Sucursal sucursal: sucursales) {
            cantidadTotalBeneficiosOtorgados = cantidadTotalBeneficiosOtorgados + sucursal.getBeneficiosOtorgados();
        }

        return cantidadTotalBeneficiosOtorgados;
    }

    public int getCantidadBeneficiosOtorgadosPorMes(Mes mes) {

        int cantidadTotalBeneficiosOtorgados = 0;

        for (Sucursal sucursal: sucursales) {
            cantidadTotalBeneficiosOtorgados = cantidadTotalBeneficiosOtorgados + sucursal.getBeneficiosOtorgadosPorMes(mes);
        }

        return cantidadTotalBeneficiosOtorgados;
    }

    public void addSucursal(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }

    public List<Sucursal> getSucursales(){
        return this.sucursales;
    }

    public double getAhorroPorCliente(Cliente cliente, Mes mes) {

        double resultado = 0;

        for (Sucursal sucursal: this.sucursales) {

            resultado = resultado + sucursal.getAhorroPorCliente(cliente,mes);

        }

        return  resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMail() {
        return mail;
    }
}
