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

    public List<Sucursal> getSucursales(){
        return this.sucursales;
    }
}
