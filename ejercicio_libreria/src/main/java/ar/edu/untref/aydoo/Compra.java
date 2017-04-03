package ar.edu.untref.aydoo;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.List;

import static ar.edu.untref.aydoo.Periodicidad.DIARIO;
import static ar.edu.untref.aydoo.Periodicidad.SEMANAL;

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

    //Trata articulos sin periodicidad
    public void addArticulo(Producto nuevoArticulo,int cantidad,Suscripcion suscripcion){

        double modificadorPrecioSuscripcion = 1;

        if(suscripcion != null){

            switch (suscripcion){
                case SIN_SUSCRIPCION:
                    modificadorPrecioSuscripcion = 1;
                    break;
                case DIARIO:
                    //TODO
                    break;
                case SEMANAL:
                    //TODO
                    break;
                case QUINCENAL:
                    //TODO
                    break;
                case MENSUAL:
                    //TODO
                    break;
                case ANUAL:
                    modificadorPrecioSuscripcion = .8;
                    break;
                default:
                    //TODO
            }

        }

        if(nuevoArticulo instanceof Libro){

            this.monto = this.monto +nuevoArticulo.getPrecio() * cantidad;

        }else if(nuevoArticulo instanceof ArticuloLibreria) {

            double iva = (nuevoArticulo.getPrecio()*cantidad)*0.21;
            this.monto = this.monto + (nuevoArticulo.getPrecio()*cantidad) + iva;

        }else if(nuevoArticulo instanceof Revista){
            this.monto = this.monto + (nuevoArticulo.getPrecio() * modificadorPrecioSuscripcion * cantidad * nuevoArticulo.getPeriodicidad().getValor());

        }else if(nuevoArticulo instanceof Diario){
            this.monto = this.monto + (nuevoArticulo.getPrecio() * modificadorPrecioSuscripcion * cantidad);
        }

    }

}
