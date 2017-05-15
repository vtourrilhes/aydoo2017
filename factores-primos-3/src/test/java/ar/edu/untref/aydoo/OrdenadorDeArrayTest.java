package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Test;

public class OrdenadorDeArrayTest {

    @Test
    public void sortAscTest(){

        OrdenadorDeArray sorter = new OrdenadorDeArray();
        Integer[] array = {5,4,3,2,7,8,10,11};

        Integer[] expected = {2,3,4,5,7,8,10,11};
        Integer[] result = sorter.ordenarArray(array);

        Assert.assertArrayEquals(expected,result);
    }

    @Test
    public void sortDescTest(){

        OrdenadorDeArray sorter = new OrdenadorDeArray();
        Integer[] array = {5,4,3,2,7,8,10,11};

        Integer[] expected = {11,10,8,7,5,4,3,2};
        Integer[] result = sorter.ordenarArrayDescendente(array);

        Assert.assertArrayEquals(expected,result);
    }
}
