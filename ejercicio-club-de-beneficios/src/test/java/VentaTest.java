import ar.edu.untref.aydoo.*;
import org.junit.Assert;
import org.junit.Test;

public class VentaTest {

    @Test
    public void aplicarDescuentoTarjetaClassicTest(){

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

        s1.addVenta(carlos, 1000.0); //Se aplica un 10% de descuento, osea 100 pesos

        double ahorroDeCarlos = clubDeBeneficio.getMontoAhorradoPorCliente(carlos);

        Assert.assertEquals(100, ahorroDeCarlos,.5);

    }

}
