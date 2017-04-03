package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Libreria {

    private HashMap<Cliente,List<Compra>> comprasPorCliente;

    public Libreria(){
        this.comprasPorCliente = new HashMap<>();
    }

    public double calcularMontoACobrar(Meses mes, Cliente cliente) {

        List<Compra> listaComprasCliente = this.comprasPorCliente.get(cliente);
        double montoTotalPorMes  = 0;

        //sumo el costo de las compras realizadas solo en el mes especificado
        for (Compra c: listaComprasCliente) {
            if(c.getMes()==mes){
                montoTotalPorMes = montoTotalPorMes + c.getMonto();
            }
        }

        return montoTotalPorMes;
    }

    public void comprar(Compra nuevaCompra) {

        Cliente cliente = nuevaCompra.getCliente();

        // Si el cliente nunca realizo una compra se lo registra ,se inicializa su lista de compras y se agrega la compra realizada
        if(!this.comprasPorCliente.containsKey(cliente)){
            this.comprasPorCliente.put(cliente,new LinkedList<Compra>());
            this.comprasPorCliente.get(cliente).add(nuevaCompra);
        }else{//Si el cliente ya realizo compras se agrega la compra a su lista
            this.comprasPorCliente.get(cliente).add(nuevaCompra);
        }

    }
}
