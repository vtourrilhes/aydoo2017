package ar.edu.untref.aydoo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class IntegracionTest {

    private final ByteArrayOutputStream salidaConsola = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(salidaConsola));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testIntegracionCaso1FormatoPrettyOutputFileSalidaTxt() throws Exception {

        Programa.main(new String[] {"360", "--format=pretty", "--output-file=salida.txt"});
        Path path = FileSystems.getDefault().getPath(".", "target/salida.txt");
        String fileContent= null;
        String expected = "Factores primos 360: 2 2 2 3 3 5 ";

        try {
            fileContent = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expected,fileContent);

    }

    @Test
    public void testIntegracionFormatoQuietSortDescCaso2() throws Exception {

        Programa.main(new String[] {"360", "--format=quiet", "--sort=desc"});
        String expected = "Factores primos 360: "+System.lineSeparator()+5+System.lineSeparator()+3+System.lineSeparator()+3+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2;

        Assert.assertEquals(expected,salidaConsola.toString());

    }

    @Test
    public void testIntegracionFormatoQuietSortAscCaso3() throws Exception {

        Programa.main(new String[] {"360", "--format=quiet", "--sort=asc"});
        String expected = "Factores primos 360: "+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+2+System.lineSeparator()+3+System.lineSeparator()+3+System.lineSeparator()+5;

        Assert.assertEquals(expected,salidaConsola.toString());

    }


}
