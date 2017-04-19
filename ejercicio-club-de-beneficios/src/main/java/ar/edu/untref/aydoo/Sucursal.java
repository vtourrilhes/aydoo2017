package ar.edu.untref.aydoo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

    public int getBeneficiosOtorgadosPorMes(Mes mes){
        int cantidadBeneficiosPorMes = 0;
        for (Venta venta: ventas) {
            if(venta.getMes().equals(mes)){
                cantidadBeneficiosPorMes = cantidadBeneficiosPorMes+1;
            }
        }

        return cantidadBeneficiosPorMes;
    }

    public int getCantidadClientesAtendidos(Mes mes){

        Set<Cliente> conjuntoClientes = new HashSet<>(); //un set asi no se repiten los clientes

        for (Venta venta: ventas) {
            if(venta.getMes().equals(mes)) {
                conjuntoClientes.add(venta.getCliente());
            }
        }

        return conjuntoClientes.size();

    }

    public List<Venta> getVentasPorMesCliente(Cliente cliente,Mes mes){

        List<Venta> ventasRealizadasACliente = new LinkedList<>();

        for (Venta venta: this.ventas){

            //si los meses coinciden y el descuento realizado sobre el producto es mayor a cero entonces la agrego a la lista de ventas
            if( mes.equals(venta.getMes()) && venta.getDescuentoRealizado()>0) {
                ventasRealizadasACliente.add(venta);
            }

        }

        return ventasRealizadasACliente;

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
