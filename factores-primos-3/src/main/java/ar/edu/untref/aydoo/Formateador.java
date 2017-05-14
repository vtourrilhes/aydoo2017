package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Formateador {

    /**
     * @return Devuelve un String listo para imprimir dado el formato
     */

    public String formatearArrayNumeros(final Integer[] array,
                                        final String formato) throws Exception {

        String respuesta = "";
        StringBuilder builder = new StringBuilder(respuesta);

        String formatoParseado = this.parseFormat(formato);

        switch (formatoParseado) {
            case "pretty":
                for (int i = 0; i < array.length; i++) {
                    builder.append(array[i] + " ");
                }
                break;
            case "quiet":
                for (int i = 0; i < array.length; i++) {
                    builder.append(System.lineSeparator() + array[i]);
                }
                break;
            default:
                throw new Exception("Formato no aceptado. "
                        + "Las opciones posibles son: pretty o quiet.");
        }

        return builder.toString();
    }

    public void writeToFile(final Integer[] array, final String formato,
                            final String fileName, final int recieviedNumber) {

        String toWrite = "";
        StringBuilder builder = new StringBuilder(toWrite);

        String formatoParseado = this.parseFormat(formato);

        switch (formatoParseado) {
            case "pretty":
                for (int i = 0; i < array.length; i++) {
                    builder.append(array[i] + " ");
                }
                break;
            case "quiet":
                for (int i = 0; i < array.length; i++) {
                    builder.append(System.lineSeparator() + array[i]);
                }
                break;
        }

        try {
            File file = new File("target", fileName);
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write("Factores primos " + recieviedNumber + ": ");
            out.write(builder.toString());  //Replace with the string
            //you are trying to write
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error creando en archivo");
        } catch (IOException e) {
            throw new RuntimeException("Error imprimendo salida en archivo");
        }

    }

    private String parseFormat(final String formato) {

        //si el formato está vacio, devuelvo pretty
        if (formato.equals("--format=")) {
            return "pretty";
        }

        formato.toLowerCase(); // lo transformo todoo a minuscula

        return formato.substring(9);
    }

}
