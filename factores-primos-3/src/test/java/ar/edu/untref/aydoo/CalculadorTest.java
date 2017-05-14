package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Test;

public class CalculadorTest {

    @Test
    public void calculatePrimeNumbers360Test() {

        Calculador c = new Calculador();
        Integer[] expected = new Integer[]{2,2,2,3,3,5};

        Assert.assertEquals(expected,c.calcularNumerosPrimos(360));

    }

    @Test
    public void calculatePrimeNumbers1Test() {

        Calculador c = new Calculador();
        Integer[] expected = new Integer[]{1};

        Assert.assertEquals(expected,c.calcularNumerosPrimos(1));

    }
}
