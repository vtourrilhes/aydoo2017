package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;


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
        String expected = "\n5\n4\n3\n2\n2\n2\n2\n2\n2";

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

}