package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Establecimiento {

    private String nombre;
    private String mail;
    private List<Beneficio> beneficios;
    private List<Sucursal> sucursales;
    private int cantidadBeneficiosOtorgados;

    public Establecimiento(String nombre, String mail) {
        this.nombre = nombre;
        this.mail = mail;
        this.beneficios = new LinkedList<>();
        this.sucursales = new LinkedList<>();
        this.cantidadBeneficiosOtorgados = 0;
    }

    public void addBeneficio(Descuento descuento) {
        this.beneficios.add(descuento);
    }

    public int getCantidadBeneficiosOtorgados() {
        return this.cantidadBeneficiosOtorgados;
    }

    public void addSucursal(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }
}
