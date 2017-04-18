import ar.edu.untref.aydoo.*;
import org.junit.Assert;
import org.junit.Test;

public class TestIntegracion {

    @Test
    public void testGetEstablecimientoConMasBeneficiosOtorgados() {
        ClubDeBeneficio clubDeBeneficio = new ClubDeBeneficio();
        // Tarjetas ofrecidas
        Tarjeta TarjetaPremium = new TarjetaPremium();
        Tarjeta TarjetaClassic = new TarjetaClassic();
        // Estableclimiento Heladeria A , sucursales y tipos de beneficio segun tarjeta
        Establecimiento heladeriaA = new Establecimiento("Heladeria A", "heladeria@restaurantB.edu.ar");
        heladeriaA.addBeneficio(new Descuento(10,TarjetaClassic));
        heladeriaA.addBeneficio(new Descuento(20,TarjetaPremium));
        Sucursal s1 = new Sucursal("s1", "Direccion s1", heladeriaA);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", heladeriaA);
        // Establecimiento Restaurant B, sucursales y tipo de beneficios segun tarjeta
        Establecimiento restaurantB = new Establecimiento("Restaurant B", "establecimiento@restaurantB.edu.ar");
        restaurantB.addBeneficio(new Descuento(20,TarjetaClassic));
        restaurantB.addBeneficio(new Descuento(20,TarjetaPremium));
        Sucursal s3 = new Sucursal("s3", "Direccion s3", restaurantB);
        // Registro de establecimiento al club de descuento
        clubDeBeneficio.addEstablecimiento(heladeriaA);
        clubDeBeneficio.addEstablecimiento(restaurantB);
        // Clientes que realizaran las operaciones
        Cliente carlos = clubDeBeneficio.addCliente("Carlos", "carlos@aydoo.edu.ar", TarjetaClassic);
        Cliente juan = clubDeBeneficio.addCliente("Juan", "juan@aydoo.edu.ar", TarjetaPremium);
        Cliente clientePremium = clubDeBeneficio.addCliente("Cliente Anonimo Premium", "premium@aydoo.edu.ar", TarjetaPremium);
        Cliente clienteClassic = clubDeBeneficio.addCliente("Cliente Anonimo Classic", "classic@aydoo.edu.ar", TarjetaPremium);

        s1.addVenta(carlos, 1000.0);
        s1.addVenta(clienteClassic, 1000.0);
        s1.addVenta(clienteClassic, 1000.0);
        s1.addVenta(clienteClassic, 1000.0);
        s1.addVenta(juan, 1000.0);
        s1.addVenta(clientePremium, 1000.0);
        s1.addVenta(clientePremium, 1000.0);
        s3.addVenta(carlos, 1000.0);
        s3.addVenta(clienteClassic, 1000.0);
        s3.addVenta(clienteClassic, 1000.0);
        s3.addVenta(clienteClassic, 500.0);
        s3.addVenta(clienteClassic, 1000.0);
        s3.addVenta(clienteClassic, 1000.0);

        Establecimiento establecimientoConMasBeneficiosOtorgados = clubDeBeneficio.getEstablecimientoConMasBeneficiosOtorgados();

        Assert.assertEquals(heladeriaA, establecimientoConMasBeneficiosOtorgados);
    }

    @Test
    public void testGetSucursalConMasBeneficiosOtorgados() {

        ClubDeBeneficio clubDeBeneficio = new ClubDeBeneficio();
        // Tarjetas ofrecidas
        Tarjeta TarjetaPremium = new TarjetaPremium();
        Tarjeta TarjetaClassic = new TarjetaClassic();
        // Estableclimiento Heladeria A , sucursales y tipos de beneficio segun tarjeta
        Establecimiento heladeriaA = new Establecimiento("Heladeria A", "heladeria@restaurantB.edu.ar");
        heladeriaA.addBeneficio(new Descuento(10,TarjetaClassic));
        heladeriaA.addBeneficio(new Descuento(20,TarjetaPremium));
        Sucursal s1 = new Sucursal("s1", "Direccion s1", heladeriaA);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", heladeriaA);
        // Establecimiento Restaurant B, sucursales y tipo de beneficios segun tarjeta
        Establecimiento restaurantB = new Establecimiento("Restaurant B", "establecimiento@restaurantB.edu.ar");
        restaurantB.addBeneficio(new Descuento(20,TarjetaClassic));
        restaurantB.addBeneficio(new Descuento(20,TarjetaPremium));
        Sucursal s3 = new Sucursal("s3", "Direccion s3", restaurantB);
        // Registro de establecimiento al club de descuento
        clubDeBeneficio.addEstablecimiento(heladeriaA);
        clubDeBeneficio.addEstablecimiento(restaurantB);
        // Clientes que realizaran las operaciones
        Cliente carlos = clubDeBeneficio.addCliente("Carlos", "carlos@aydoo.edu.ar", TarjetaClassic);
        Cliente juan = clubDeBeneficio.addCliente("Juan", "juan@aydoo.edu.ar", TarjetaPremium);
        Cliente clientePremium = clubDeBeneficio.addCliente("Cliente Anonimo Premium", "premium@aydoo.edu.ar", TarjetaPremium);
        Cliente clienteClassic = clubDeBeneficio.addCliente("Cliente Anonimo Classic", "classic@aydoo.edu.ar", TarjetaPremium);

        s1.addVenta(carlos, 1000.0);
        s1.addVenta(clienteClassic, 1000.0);
        s1.addVenta(clienteClassic, 1000.0);
        s1.addVenta(clienteClassic, 1000.0);
        s1.addVenta(juan, 1000.0);
        s1.addVenta(clientePremium, 1000.0);
        s1.addVenta(clientePremium, 1000.0);
        s3.addVenta(carlos, 1000.0);
        s3.addVenta(clienteClassic, 1000.0);
        s3.addVenta(clienteClassic, 1000.0);
        s3.addVenta(clienteClassic, 500.0);
        s3.addVenta(clienteClassic, 1000.0);
        s3.addVenta(clienteClassic, 1000.0);

        Sucursal sucursalConMasBeneficiosOtorgados = clubDeBeneficio.getSucursalConMasBeneficiosOtorgados();

        Assert.assertEquals(s1, sucursalConMasBeneficiosOtorgados);
    }

    @Test
    public void testGetTotalDeAhorroPorCliente() {

        ClubDeBeneficio clubDeBeneficio = new ClubDeBeneficio();
        // Tarjetas ofrecidas
        Tarjeta TarjetaPremium = new TarjetaPremium();
        Tarjeta TarjetaClassic = new TarjetaClassic();
        // Estableclimiento Heladeria A , sucursales y tipos de beneficio segun tarjeta
        Establecimiento heladeriaA = new Establecimiento("Heladeria A", "heladeria@restaurantB.edu.ar");
        heladeriaA.addBeneficio(new Descuento(10,TarjetaClassic));
        heladeriaA.addBeneficio(new Descuento(20,TarjetaPremium));
        Sucursal s1 = new Sucursal("s1", "Direccion s1", heladeriaA);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", heladeriaA);
        // Establecimiento Restaurant B, sucursales y tipo de beneficios segun tarjeta
        Establecimiento restaurantB = new Establecimiento("Restaurant B", "establecimiento@restaurantB.edu.ar");
        restaurantB.addBeneficio(new Descuento(20,TarjetaClassic));
        restaurantB.addBeneficio(new Descuento(20,TarjetaPremium));
        Sucursal s3 = new Sucursal("s3", "Direccion s3", restaurantB);
        // Registro de establecimiento al club de descuento
        clubDeBeneficio.addEstablecimiento(heladeriaA);
        clubDeBeneficio.addEstablecimiento(restaurantB);
        // Clientes que realizaran las operaciones
        Cliente carlos = clubDeBeneficio.addCliente("Carlos", "carlos@aydoo.edu.ar", TarjetaClassic);
        Cliente juan = clubDeBeneficio.addCliente("Juan", "juan@aydoo.edu.ar", TarjetaPremium);
        Cliente clientePremium = clubDeBeneficio.addCliente("Cliente Anonimo Premium", "premium@aydoo.edu.ar", TarjetaPremium);
        Cliente clienteClassic = clubDeBeneficio.addCliente("Cliente Anonimo Classic", "classic@aydoo.edu.ar", TarjetaPremium);

        s1.addVenta(carlos, 1000.0);
        s1.addVenta(clienteClassic, 1000.0);
        s1.addVenta(clienteClassic, 1000.0);
        s1.addVenta(clienteClassic, 1000.0);
        s1.addVenta(juan, 1000.0);
        s1.addVenta(clientePremium, 1000.0);
        s1.addVenta(clientePremium, 1000.0);
        s3.addVenta(carlos, 1000.0);
        s3.addVenta(clienteClassic, 1000.0);
        s3.addVenta(clienteClassic, 1000.0);
        s3.addVenta(clienteClassic, 500.0);
        s3.addVenta(clienteClassic, 1000.0);
        s3.addVenta(clienteClassic, 1000.0);

        double ahorroDeCarlos = clubDeBeneficio.getMontoAhorradoPorCliente(carlos);

        Assert.assertEquals("2222", ahorroDeCarlos);

    }

}
