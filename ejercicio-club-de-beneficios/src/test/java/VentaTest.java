import ar.edu.untref.aydoo.*;
import org.junit.Assert;
import org.junit.Test;

public class VentaTest {

    @Test
    public void descuentoRealizado10PorCientoDeTotal000(){

        ClubDeBeneficio clubDeBeneficio = new ClubDeBeneficio();
        // Tarjetas ofrecidas
        Tarjeta TarjetaClassic = new TarjetaClassic();
        // Estableclimiento Heladeria A , sucursales y tipos de beneficio segun tarjeta
        Establecimiento heladeriaA = new Establecimiento("Heladeria A", "heladeria@restaurantB.edu.ar");
        heladeriaA.addBeneficio(new Descuento(10,TarjetaClassic));
        Sucursal s1 = new Sucursal("s1", "Direccion s1", heladeriaA);
        clubDeBeneficio.addEstablecimiento(heladeriaA);
        // Clientes que realizaran las operaciones
        Cliente carlos = clubDeBeneficio.addCliente("Carlos", "carlos@aydoo.edu.ar", TarjetaClassic);

        Venta venta1 = new Venta(carlos,new Producto("Helado tiramiss",1000),s1);


        Assert.assertEquals(100, venta1.getDescuentoRealizado(),.5);

    }

}
