package ar.edu.untref.aydoo;

import java.util.List;

public class MailService {

    public static String sendMailFelicitacionEstablecimiento(Establecimiento establecimiento){

        return  "Felicitaciones " + establecimiento.getNombre() + "!";

    }

    public static String sendMailFelicitacionSucursal(Sucursal sucursal) {

        return "Felicitaciones " + sucursal.getNombre() + "!";

    }

    public static String sendReporteCliente(Cliente cliente, Mes mes, List<Venta> comprasCliente) {

        String email = "";
        StringBuilder builder = new StringBuilder(email);
        builder.append("Compras realizadas por cliente ").append(cliente.getNombre()).append(System.getProperty("line.separator"));


        //por cada producto de la lista voy a enviar datos de cada venta realizada
        double descuentosTotalesPorCliente = 0;

        for (Venta venta: comprasCliente) {

            //armo el string del mail
            builder.append("Producto: ").append(venta.getProducto().getNombre()).append(" Precio bruto producto: ").append(venta.getProducto().getPrecio()).append(" Descuento realizado en producto: ").append(venta.getDescuentoRealizado()).append(" Establecimiento: ").append(venta.getSucursal().getEstablecimiento().getNombre()).append(System.getProperty("line.separator"));

            descuentosTotalesPorCliente = descuentosTotalesPorCliente + venta.getDescuentoRealizado();
        }

        //especifico descuentos totales realizados
        builder.append("Suma de descuentos en ").append(mes.toString().toLowerCase()).append(": ").append(descuentosTotalesPorCliente);

        //envio el mail
        return builder.toString();

    }
}
