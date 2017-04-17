package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySorter {

    public Integer[] sortArray(String format, Integer[] array) {

        Integer[] sorted = array;

        //paso a lowercase el formato y convierto el array a coleccion para ordenar
        format.toLowerCase();
        List<Integer> ordering = Arrays.asList(sorted);

        if(format.contains("asc")) {
            Collections.sort(ordering);
        }else if(format.contains("desc")) {
            Collections.sort(ordering);
            Collections.reverse(ordering);
        }

        sorted = (Integer[]) ordering.toArray();

        return sorted;
    }

}
