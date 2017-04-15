package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

/**
 * Tipo de objeto: Entity
 * */
public class Compra {

    private List<Producto> articulos;
    private Cliente cliente;
    private Meses mes;
    private double monto;

    public Compra(Cliente cliente, Meses mes){
        this.articulos = new LinkedList<>();
        this.cliente = cliente;
        this.mes = mes;
        this.monto = 0;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public Meses getMes() {
        return mes;
    }

    public double getMonto() {
        return monto;
    }

    public void addArticulo(Producto nuevoArticulo,int cantidad){

        this.monto = this.monto + nuevoArticulo.getPrecio() * cantidad;
    }

}
