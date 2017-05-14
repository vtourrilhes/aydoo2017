package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Calculador {

    public Integer[] calcularNumerosPrimos(int numeroRecibido) {

        if (numeroRecibido == 1) {
            return new Integer[]{1};
        }

        List<Integer> listaNumeros = new ArrayList<>();

        while (numeroRecibido != 1) {
            int respuesta = getLeastPrimeFactor(numeroRecibido);
            listaNumeros.add(respuesta);
            numeroRecibido = numeroRecibido / respuesta;
        }

        Integer[] respuestaArray = new Integer[listaNumeros.size()];
        respuestaArray = listaNumeros.toArray(respuestaArray);
        return respuestaArray;
    }

    public static int getLeastPrimeFactor(int number) {

        int respuesta = 2;

        while (number % respuesta != 0) {
            respuesta++;
        }

        return respuesta;
    }
}
