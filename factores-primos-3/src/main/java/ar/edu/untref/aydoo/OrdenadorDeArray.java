package ar.edu.untref.aydoo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdenadorDeArray {

    public Integer[] ordenarArray(final  Integer[] array) {

        Integer[] ordenado = array;
        List<Integer> ordering = Arrays.asList(ordenado);
        Collections.sort(ordering);
        ordenado = (Integer[]) ordering.toArray();

        return ordenado;
    }

    public Integer[] ordenarArrayDescendente(Integer[] array) {

        Integer[] ordenado = array;
        List<Integer> ordering = Arrays.asList(ordenado);
        Collections.sort(ordering);
        Collections.reverse(ordering);
        ordenado = (Integer[]) ordering.toArray();

        return ordenado;
    }

}
