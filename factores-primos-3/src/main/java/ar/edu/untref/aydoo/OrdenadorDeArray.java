package ar.edu.untref.aydoo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdenadorDeArray {

    public Integer[] sortArray(final String formato, final  Integer[] array) {

        Integer[] ordenado = array;

        //paso a lowercase el formatoo y convierto
        // el array a coleccion para ordenar
        formato.toLowerCase();
        List<Integer> ordering = Arrays.asList(ordenado);

        if (formato.contains("asc")) {
            Collections.sort(ordering);
        } else if (formato.contains("des")) {
            Collections.sort(ordering);
            Collections.reverse(ordering);
        }

        ordenado = (Integer[]) ordering.toArray();

        return ordenado;
    }

}
