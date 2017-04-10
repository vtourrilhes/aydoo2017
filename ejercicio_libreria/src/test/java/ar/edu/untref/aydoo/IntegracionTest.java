package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionTest {


    @Test
    public void testCompraCaso1(){

        Libreria libreria = new Libreria();
        Cliente juan = new Cliente("Juan");
        Revista elGrafico = new Revista("El Grafico",30,Periodicidad.MENSUAL);
        Libro elHobbit = new Libro(50,"El Hobbit");
        ArticuloLibreria lapicera = new ArticuloLibreria("Lapicera",5);

        Compra compra = new Compra(juan,Meses.AGOSTO);
        compra.addArticulo(elHobbit,1);
        compra.addArticulo(elGrafico,1);
        compra.addArticulo(lapicera,2);
        libreria.comprar(compra);

        double resultado = libreria.calcularMontoACobrar(Meses.AGOSTO,juan);

        Assert.assertEquals(92,resultado,.5);

    }


    @Test
    public void testCompraCaso2(){

        Libreria libreria = new Libreria();
        Cliente maria = new Cliente("Maria");
        Suscripcion suscripcionBarcelona = new Suscripcion(TipoSuscripcion.ANUAL);
        Revista barcelona = new Revista("Barcelona",20,suscripcionBarcelona,Periodicidad.QUINCENAL);
        Diario pagina12 = new Diario("Pagina 12",12,Periodicidad.DIARIO);

        Compra compra = new Compra(maria,Meses.ENERO);
        compra.addArticulo(barcelona,1);
        compra.addArticulo(pagina12,1);
        libreria.comprar(compra);

        double resultado = libreria.calcularMontoACobrar(Meses.ENERO,maria);

        Assert.assertEquals(44,resultado,.5);

    }

    @Test
    public void testCompraIgnorarMesesQueNoSePiden(){

        Libreria libreria = new Libreria();
        Cliente maria = new Cliente("Maria");
        Suscripcion suscripcionBarcelona = new Suscripcion(TipoSuscripcion.ANUAL);
        Revista barcelona = new Revista("Barcelona",20,suscripcionBarcelona,Periodicidad.QUINCENAL);
        Diario pagina12 = new Diario("Pagina 12",12,Periodicidad.DIARIO);
        Compra compra = new Compra(maria,Meses.ENERO);
        Compra compra2 = new Compra(maria,Meses.ENERO);
        Compra compra3 = new Compra(maria,Meses.MARZO);
        compra.addArticulo(barcelona,1);
        compra.addArticulo(pagina12,1);
        compra2.addArticulo(barcelona,1);
        compra2.addArticulo(pagina12,1);
        compra3.addArticulo(barcelona,1);
        compra3.addArticulo(pagina12,1);


        libreria.comprar(compra);
        libreria.comprar(compra2);
        libreria.comprar(compra3);
        double resultado = libreria.calcularMontoACobrar(Meses.ENERO,maria);

        Assert.assertEquals(44*2,resultado,.5);

    }

    @Test
    public void testCompraVaciaEnMesEspecificado(){

        Libreria libreria = new Libreria();
        Cliente maria = new Cliente("Maria");
        Suscripcion suscripcionBarcelona = new Suscripcion(TipoSuscripcion.ANUAL);
        Revista barcelona = new Revista("Barcelona",20,suscripcionBarcelona,Periodicidad.QUINCENAL);
        Diario pagina12 = new Diario("Pagina 12",12,Periodicidad.DIARIO);
        Compra compra = new Compra(maria,Meses.ENERO);
        Compra compra2 = new Compra(maria,Meses.ENERO);
        Compra compra3 = new Compra(maria,Meses.MARZO);
        compra.addArticulo(barcelona,1);
        compra.addArticulo(pagina12,1);
        compra2.addArticulo(barcelona,1);
        compra2.addArticulo(pagina12,1);
        compra3.addArticulo(barcelona,1);
        compra3.addArticulo(pagina12,1);


        libreria.comprar(compra);
        libreria.comprar(compra2);
        libreria.comprar(compra3);
        double resultado = libreria.calcularMontoACobrar(Meses.JULIO,maria);

        Assert.assertEquals(0,resultado,.5);

    }

}
