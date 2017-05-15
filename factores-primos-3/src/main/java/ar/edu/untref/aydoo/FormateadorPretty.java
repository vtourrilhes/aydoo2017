package ar.edu.untref.aydoo;

import java.io.*;

public class FormateadorPretty extends Formateador{

    public FormateadorPretty(){
        super();
    }

    @Override
    public String formatearArrayNumeros(Integer[] array) throws Exception {

        for (int i = 0; i < array.length; i++) {
            this.builder.append(array[i] + " ");
        }

        return builder.toString();

    }

    @Override
    public void writeToFile(Integer[] array, String formato, String fileName, int recieviedNumber) {
            String toWrite = "";
            StringBuilder builder = new StringBuilder(toWrite);

            for (int i = 0; i < array.length; i++) {
                builder.append(array[i] + " ");
            }

            super.escribirArchivo(fileName,recieviedNumber,builder);

    }

}
