import ar.edu.untref.aydoo.Descuento;
import ar.edu.untref.aydoo.Exception.DescuentoInvalidoException;
import ar.edu.untref.aydoo.TarjetaClassic;
import org.junit.Test;

public class DescuentoTest {

    @Test(expected = DescuentoInvalidoException.class)
    public void testDescuentoInvalidoException() throws DescuentoInvalidoException {

       Descuento descuento = new Descuento(4,new TarjetaClassic());

    }

}
