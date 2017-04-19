package ar.edu.untref.aydoo;

import java.util.List;

public class MailService {

    public static String sendMailFelicitacionEstablecimiento(Establecimiento establecimiento){

        String email = "Felicitaciones " + establecimiento.getNombre() + "!";

        return email;
    }

    public static String sendMailFelicitacionSucursal(Sucursal sucursal) {

        String email = "Felicitaciones " + sucursal.getNombre() + "!";

        return email;

    }

    public static String sendReporteCliente(Cliente cliente, Mes mes, List<Venta> comprasCliente) {

        String email = "";
        StringBuilder builder = new StringBuilder(email);
        builder.append("Compras realizadas por cliente "+cliente.getNombre()+System.getProperty("line.separator"));


        //por cada producto de la lista voy a enviar datos de cada venta realizada
        double descuentosTotalesPorCliente = 0;

        for (Venta venta: comprasCliente) {

            //armo el string del mail
            builder.append("Producto: "+venta.getProducto().getNombre()+
                            " Precio bruto producto: "+venta.getProducto().getPrecio()+
                            " Descuento realizado en producto: "+venta.getDescuentoRealizado()+
                            " Establecimiento: "+venta.getSucursal().getEstablecimiento().getNombre()+
                            System.getProperty("line.separator")
            );

            descuentosTotalesPorCliente = descuentosTotalesPorCliente + venta.getDescuentoRealizado();
        }

        //especifico descuentos totales realizados
        builder.append("Suma de descuentos en "+ mes.toString().toLowerCase()+": "+descuentosTotalesPorCliente);

        //envio el mail
        return email;

    }
}
