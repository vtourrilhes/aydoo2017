package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Test;

public class ArraySorterTest {

    @Test
    public void sortAscTest(){

        ArraySorter sorter = new ArraySorter();
        Integer[] array = {5,4,3,2,7,8,10,11};

        Integer[] expected = {2,3,4,5,7,8,10,11};
        Integer[] result = sorter.sortArray("--order:asc",array);

        Assert.assertArrayEquals(expected,result);
    }

    @Test
    public void sortDescTest(){

        ArraySorter sorter = new ArraySorter();
        Integer[] array = {5,4,3,2,7,8,10,11};

        Integer[] expected = {11,10,8,7,5,4,3,2};
        Integer[] result = sorter.sortArray("--order:desc",array);

        Assert.assertArrayEquals(expected,result);
    }
}
