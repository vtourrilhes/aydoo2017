import ar.edu.untref.aydoo.*;
import ar.edu.untref.aydoo.Exception.DescuentoInvalidoException;
import org.junit.Assert;
import org.junit.Test;

public class ClubDeBeneficioIntegracionTest {

    @Test
    public void enviarReporteDeAhorrosTest() throws DescuentoInvalidoException {

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

        s1.addVenta(carlos, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(juan, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clientePremium, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clientePremium, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(carlos, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",500), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);

        Assert.assertEquals(4, clubDeBeneficio.enviarReporteDeAhorros(Mes.ENERO));

    }

    @Test
    public void felicitarEstablecimientoTest() throws DescuentoInvalidoException {

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

        s1.addVenta(carlos, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(juan, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clientePremium, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clientePremium, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(carlos, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",500), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);

        Assert.assertEquals(heladeriaA, clubDeBeneficio.felicitarEstablecimiento(Mes.ENERO));

    }

    @Test
    public void enviarRegaloMensualASucursalTest() throws DescuentoInvalidoException {

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

        s1.addVenta(carlos, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(juan, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clientePremium, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clientePremium, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(carlos, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",500), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);

        Assert.assertEquals(s1, clubDeBeneficio.enviarRegaloMensualASucursal(Mes.ENERO));

    }
}
