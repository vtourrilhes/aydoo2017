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

    public void addVenta(Cliente cliente, Producto producto, Mes mes) {

        this.beneficiosOtorgados ++;

        this.ventas.add(new Venta(cliente,producto,this,mes));
    }

    public List<Venta> getVentas(){
        return  this.ventas;
    }

    public int getBeneficiosOtorgados(){
        return this.beneficiosOtorgados;
    }

    public double getAhorroPorCliente(Cliente cliente, Mes mes) {

        double resultado = 0;

        for (Venta venta: ventas) {
            if (cliente.equals(venta.getCliente()) && venta.getMes().equals(mes)) {
                resultado = resultado + venta.getDescuentoRealizado();
            }
        }

        return  resultado;
    }
}
