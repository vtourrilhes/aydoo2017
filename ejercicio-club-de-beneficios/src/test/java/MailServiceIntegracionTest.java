import ar.edu.untref.aydoo.*;
import ar.edu.untref.aydoo.Exception.DescuentoInvalidoException;
import org.junit.Assert;
import org.junit.Test;

public class MailServiceIntegracionTest {

    @Test
    public void sendMailFelicitacionEstablecimiento() throws DescuentoInvalidoException {

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

        s1.addVenta(carlos, new Producto("Helado",1000), Mes.ENERO); //100 pesos ahorrados
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(juan, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clientePremium, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clientePremium, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(carlos, new Producto("Helado",1000), Mes.ENERO); //200 pesos ahorrados
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",500), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);

        String mail = MailService.sendMailFelicitacionEstablecimiento(clubDeBeneficio.getEstablecimientoConMasBeneficiosOtorgados());

        Assert.assertEquals("Felicitaciones Heladeria A!", mail);

    }

    @Test
    public void sendMailFelicitacionSucursal() throws DescuentoInvalidoException {

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

        s1.addVenta(carlos, new Producto("Helado",1000), Mes.ENERO); //100 pesos ahorrados
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(juan, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clientePremium, new Producto("Helado",1000), Mes.ENERO);
        s1.addVenta(clientePremium, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(carlos, new Producto("Helado",1000), Mes.ENERO); //200 pesos ahorrados
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",500), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);
        s3.addVenta(clienteClassic, new Producto("Helado",1000), Mes.ENERO);

        String mail = MailService.sendMailFelicitacionSucursal(clubDeBeneficio.getSucursalConMasBeneficiosOtorgados());

        Assert.assertEquals("Felicitaciones s1!", mail);

    }


    @Test
    public void sendReporteCliente() throws DescuentoInvalidoException {

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

        s1.addVenta(carlos, new Producto("Helado",1000), Mes.ENERO); //100 pesos ahorrados
        s1.addVenta(carlos, new Producto("Helado",80), Mes.ENERO);      // 8 ahorrados
        s1.addVenta(carlos, new Producto("Helado",20), Mes.ENERO);      //2 ahorrados
        s1.addVenta(carlos, new Producto("Helado",50), Mes.JULIO);      //5 ahorrados, pero se ignoran porque es julio

        String mail = MailService.sendReporteCliente(carlos, Mes.ENERO,s1.getVentasPorMesCliente(carlos,Mes.ENERO));
        String expected = "Compras realizadas por cliente Carlos"+System.getProperty("line.separator") +
                "Producto: Helado Precio bruto producto: 1000.0 Descuento realizado en producto: 100.0 Establecimiento: Heladeria A"+System.getProperty("line.separator") +
                "Producto: Helado Precio bruto producto: 80.0 Descuento realizado en producto: 8.0 Establecimiento: Heladeria A"+System.getProperty("line.separator") +
                "Producto: Helado Precio bruto producto: 20.0 Descuento realizado en producto: 2.0 Establecimiento: Heladeria A"+System.getProperty("line.separator") +
                        "Suma de descuentos en enero: 110.0";

        Assert.assertEquals(expected, mail);

    }
}
