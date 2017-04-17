package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Formatter {

    /**
     * @return Devuelve un String listo para imprimir dado el formato
     */

    public String formatArrayNumbers(final Integer[] array,
                                     final String format) throws Exception {

        String answer = "";
        StringBuilder builder = new StringBuilder(answer);

        String parsedFormat = this.parseFormat(format);

        switch (parsedFormat) {
            case "pretty":
                for (int i = 0; i < array.length; i++) {
                    builder.append(array[i] + " ");
                }
                break;
            case "quiet":
                System.out.println();
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

    public void writeToFile(final Integer[] array, final String format,
                            final String fileName, final int recieviedNumber) {

        String toWrite = "";
        StringBuilder builder = new StringBuilder(toWrite);

        String parsedFormat = this.parseFormat(format);

        switch (parsedFormat) {
            case "pretty":
                for (int i = 0; i < array.length; i++) {
                    builder.append(array[i] + " ");
                }
                break;
            case "quiet":
                System.out.println();
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

    private String parseFormat(final String format) {

        //si el formato está vacio, devuelvo pretty
        if (format.equals("--format=")) {
            return "pretty";
        }

        format.toLowerCase(); // lo transformo todoo a minuscula

        return format.substring(9);
    }

}
