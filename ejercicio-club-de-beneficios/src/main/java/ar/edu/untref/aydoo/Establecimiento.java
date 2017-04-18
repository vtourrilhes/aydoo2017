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

    public void addBeneficio(Descuento descuento) {
        this.beneficios.add(descuento);
    }

    public int getCantidadBeneficiosOtorgados() {

        int cantidadTotalBeneficiosOtorgados = 0;

        for (Sucursal sucursal: sucursales) {
            cantidadTotalBeneficiosOtorgados = cantidadTotalBeneficiosOtorgados + sucursal.getBeneficiosOtorgados();
        }

        return cantidadTotalBeneficiosOtorgados;
    }

    public void addSucursal(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }
}
