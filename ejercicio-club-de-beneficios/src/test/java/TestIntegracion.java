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

        double ahorroDeCarlos = clubDeBeneficio.getMontoAhorradoPorCliente(carlos);

        Assert.assertEquals(300, ahorroDeCarlos,.5);

    }

    @Test
    public void aplicarDescuentoTarjetaClassicUnicaCompraTest(){

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

        s1.addVenta(carlos, new Producto("Helado",1000), Mes.ENERO); //Se aplica un 10% de descuento, osea 100 pesos

        double ahorroDeCarlos = clubDeBeneficio.getMontoAhorradoPorCliente(carlos);

        Assert.assertEquals(100, ahorroDeCarlos,.5);

    }

    @Test
    public void aplicarDescuentoTarjetaClassicMultiplesComprasTest(){

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

        s1.addVenta(carlos, new Producto("Helado",1000),Mes.ENERO); //Se aplica un 10% de descuento, osea 100 pesos
        s1.addVenta(carlos, new Producto("Helado",500),Mes.ENERO); //Se aplica un 10% de descuento, osea 50 pesos
        s1.addVenta(carlos, new Producto("Helado",100),Mes.ENERO); //Se aplica un 10% de descuento, osea 10 pesos

        double ahorroDeCarlos = clubDeBeneficio.getMontoAhorradoPorCliente(carlos);

        Assert.assertEquals(160, ahorroDeCarlos,.5);

    }


}
