package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FormateadorTest {

    @Test
    public void prettyFormatTest() {

        Formateador formateador = new FormateadorPretty();
        Integer[] numbers = new Integer[]{2,2,2,2,2,2,3,4,5};
        String expected = "2 2 2 2 2 2 3 4 5 ";

        try {
            Assert.assertEquals(expected, formateador.formatearArrayNumeros(numbers));
        } catch (Exception e) {
            
        }

    }

    @Test
    public void quietFormatTest() {

        Formateador formateador = new FormateadorQuiet();
        Integer[] numbers = new Integer[]{2,2,2,2,2,2,3,4,5};
        String expected = System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+3+System.lineSeparator()+4+System.lineSeparator()+5;

        try {
            Assert.assertEquals(expected, formateador.formatearArrayNumeros(numbers));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void fileCreatedTest() {

        Formateador formateador = new FormateadorQuiet();
        Integer[] numbers = new Integer[]{2,2,2,2,2,2,3,4,5};

        try {
            formateador.writeToFile(numbers,"quiet","testing.txt",360);
        } catch (Exception e) {
            e.printStackTrace();
        }

        File isFileCreated = new File("target/testing.txt");
        Assert.assertTrue(isFileCreated.exists());

    }

    @Test
    public void fileCreatedCorrectlyFormatQuietNameTestingTxt() {

        Formateador formateador = new FormateadorQuiet();
        Integer[] numbers = new Integer[]{2,2,2,2,2,2,3,4,5};
        String expected = "Factores primos 360: "+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+3+System.lineSeparator()+4+System.lineSeparator()+5;
        String fileContent= null;
        try {
            formateador.writeToFile(numbers,"quiet","testing.txt",360);
            Path path = FileSystems.getDefault().getPath(".", "target/testing.txt");
            fileContent = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(fileContent,expected);

    }

    @Test
    public void fileCreatedCorrectlyFormatPrettyNameTestingTxt() {

        Formateador formateador = new FormateadorPretty();
        Integer[] numbers = new Integer[]{2,2,2,2,2,2,3,4,5};
        String expected = "Factores primos 360: 2 2 2 2 2 2 3 4 5 ";
        String fileContent= null;
        try {
            formateador.writeToFile(numbers,"pretty","testing.txt",360);
            Path path = FileSystems.getDefault().getPath(".", "target/testing.txt");
            fileContent = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(fileContent,expected);

    }

}