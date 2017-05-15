package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Formateador {

    protected String respuesta;
    protected StringBuilder builder;

    /**
     * @return Devuelve un String listo para imprimir dado el formato
     */

    public Formateador(){
        respuesta = "";
        builder = new StringBuilder(respuesta);
    }

    public abstract String formatearArrayNumeros(final Integer[] array) throws Exception ;


    public abstract void writeToFile(final Integer[] array, final String formato,
                            final String fileName, final int recieviedNumber);

    protected void escribirArchivo(String fileName, int recieviedNumber, StringBuilder builder){
        try {
            File file = new File("target", fileName);
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write("Factores primos " + recieviedNumber + ": ");
            out.write(builder.toString());

            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error creando en archivo");
        } catch (IOException e) {
            throw new RuntimeException("Error imprimendo salida en archivo");
        }
    }
}
