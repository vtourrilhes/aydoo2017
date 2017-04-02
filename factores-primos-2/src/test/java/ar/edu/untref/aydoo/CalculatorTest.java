package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void calculatePrimeNumbers360Test() {

        Calculator c = new Calculator();
        Integer[] expected = new Integer[]{2,2,2,3,3,5};

        Assert.assertEquals(expected,c.calculatePrimeNumbers(360));

    }

    @Test
    public void calculatePrimeNumbers1Test() {

        Calculator c = new Calculator();
        Integer[] expected = new Integer[]{1};

        Assert.assertEquals(expected,c.calculatePrimeNumbers(1));

    }
}
