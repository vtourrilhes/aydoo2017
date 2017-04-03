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
        compra.addArticulo(elHobbit,1,null);
        compra.addArticulo(elGrafico,1,Suscripcion.SIN_SUSCRIPCION);
        compra.addArticulo(lapicera,2,null);
        libreria.comprar(compra);

        double resultado = libreria.calcularMontoACobrar(Meses.AGOSTO,juan);

        Assert.assertEquals(92,resultado,.5);

    }


    @Test
    public void testCompraCaso2(){

        Libreria libreria = new Libreria();
        Cliente maria = new Cliente("Maria");
        Revista barcelona = new Revista("Barcelona",20,Periodicidad.QUINCENAL);
        ArticuloLibreria lapicera = new ArticuloLibreria("Lapicera",5);
        Diario pagina12 = new Diario("Pagina 12",12);

        Compra compra = new Compra(maria,Meses.ENERO);
        compra.addArticulo(barcelona,1,Suscripcion.ANUAL);
        compra.addArticulo(pagina12,1,null);
        libreria.comprar(compra);

        double resultado = libreria.calcularMontoACobrar(Meses.ENERO,maria);

        Assert.assertEquals(44,resultado,.5);

    }

}
