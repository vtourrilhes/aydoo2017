package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Sucursal {

    private Establecimiento establecimiento;
    private List<Venta> ventas;
    private String nombre;
    private String direccion;
    private int beneficiosOtorgados;

    public Sucursal(String nombre, String direccion, Establecimiento establecimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.establecimiento = establecimiento;
        establecimiento.addSucursal(this);
        this.ventas = new LinkedList<>();
        this.beneficiosOtorgados = 0;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void addVenta(Cliente cliente, double monto) {

        this.beneficiosOtorgados ++;

        this.ventas.add(new Venta(cliente,monto));
    }

    public int getBeneficiosOtorgados(){
        return this.beneficiosOtorgados;
    }
}
