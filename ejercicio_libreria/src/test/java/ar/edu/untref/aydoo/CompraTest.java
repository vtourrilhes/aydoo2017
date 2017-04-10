package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CompraTest {

    @Test
    public void compraVacia(){

        Cliente maria = new Cliente("Maria");
        Compra compra = new Compra(maria,Meses.ENERO);

        double resultado = compra.getMonto();

        Assert.assertEquals(0,resultado,.1);

    }

    @Test
    public void testCompraDiarioSuscripcionAnual(){

        Cliente maria = new Cliente("Maria");
        Suscripcion suscripcionDiario = new Suscripcion(TipoSuscripcion.ANUAL);
        Diario pagina12 = new Diario("Pagina 12",12,suscripcionDiario,Periodicidad.DIARIO);

        Compra compra = new Compra(maria,Meses.ENERO);
        compra.addArticulo(pagina12,1);

        double resultado = compra.getMonto();

        Assert.assertEquals(12*31*0.8,resultado,.5);

    }

    @Test
    public void compraRevistaSuscripcionMensualPeriodicidadQuincenal40unidades(){

        Cliente maria = new Cliente("Maria");
        Suscripcion suscripcionDiario = new Suscripcion(TipoSuscripcion.MENSUAL);
        Revista barcelona = new Revista("Barcelona",30,suscripcionDiario,Periodicidad.QUINCENAL);

        Compra compra = new Compra(maria,Meses.ENERO);
        compra.addArticulo(barcelona,40);

        double resultado = compra.getMonto();

        Assert.assertEquals(30*1*2*40,resultado,.5);

    }

}
