package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;


public class FormatterTest {

    @Test
    public void prettyFormatTest() {

        Formatter formatter = new Formatter();
        Integer[] numbers = new Integer[]{2,2,2,2,2,2,3,4,5};
        String expected = "2 2 2 2 2 2 3 4 5 ";

        try {
            Assert.assertEquals(expected,formatter.formatArrayNumbers(numbers,"--Format:pretty"));
        } catch (Exception e) {
            
        }

    }

    @Test
    public void prettyFormatTestUpperAndLowerCase() {

        Formatter formatter = new Formatter();
        Integer[] numbers = new Integer[]{2,2,2,2,2,2,3,4,5};
        String expected = "2 2 2 2 2 2 3 4 5 ";

        try {
            Assert.assertEquals(expected,formatter.formatArrayNumbers(numbers,"--Format:pReTTy"));
        } catch (Exception e) {

        }

    }

    @Test
    public void nonFormatSpecifiedTest() {

        Formatter formatter = new Formatter();
        Integer[] numbers = new Integer[]{2,2,2,2,2,2,3,4,5};
        String expected = "2 2 2 2 2 2 3 4 5 ";

        try {
            Assert.assertEquals(expected,formatter.formatArrayNumbers(numbers,""));
        } catch (Exception e) {

        }

    }

    @Test
    public void quietFormatTest() {

        Formatter formatter = new Formatter();
        Integer[] numbers = new Integer[]{2,2,2,2,2,2,3,4,5};
        String expected = "\n2\n2\n2\n2\n2\n2\n3\n4\n5";

        try {
            Assert.assertEquals(expected,formatter.formatArrayNumbers(numbers,"--Format:quiet"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test(expected=Exception.class)
    public void NotValidFormatTest() throws Exception {

        Formatter formatter = new Formatter();
        Integer[] numbers = new Integer[]{2,2,2,2,2,2,3,4,5};
        String expected = "\n2\n2\n2\n2\n2\n2\n3\n4\n5";

        Assert.assertEquals(expected,formatter.formatArrayNumbers(numbers,"--Format:yerba"));


    }

    @Test
    public void fileCreatedTest() {

        Formatter formatter = new Formatter();
        Integer[] numbers = new Integer[]{2,2,2,2,2,2,3,4,5};
        String expected = "\n2\n2\n2\n2\n2\n2\n3\n4\n5";

        try {
            formatter.writeToFile(numbers,"--Format:quiet","testing.txt",360);
        } catch (Exception e) {
            e.printStackTrace();
        }

        File isFileCreated = new File("testing.txt");
        Assert.assertTrue(isFileCreated.exists());

    }

    @Test
    public void fileCreatedCorrectlyFormatQuietNameTestingTxt() {

        Formatter formatter = new Formatter();
        Integer[] numbers = new Integer[]{2,2,2,2,2,2,3,4,5};
        String expected = "Factores primos 360: "+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+3+System.lineSeparator()+4+System.lineSeparator()+5;
        String fileContent= null;
        String content = null;
        try {
            formatter.writeToFile(numbers,"--Format:quiet","testing.txt",360);
            Path path = FileSystems.getDefault().getPath(".", "testing.txt");
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

        Formatter formatter = new Formatter();
        Integer[] numbers = new Integer[]{2,2,2,2,2,2,3,4,5};
        String expected = "Factores primos 360: 2 2 2 2 2 2 3 4 5 ";
        String fileContent= null;
        String content = null;
        try {
            formatter.writeToFile(numbers,"--Format:pretty","testing.txt",360);
            Path path = FileSystems.getDefault().getPath(".", "testing.txt");
            fileContent = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(fileContent,expected);

    }

}