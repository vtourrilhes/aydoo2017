import ar.edu.untref.aydoo.DosPorUno;
import ar.edu.untref.aydoo.Exception.DosPorUnoInvalidoException;
import ar.edu.untref.aydoo.Producto;
import ar.edu.untref.aydoo.TarjetaClassic;
import org.junit.Test;

public class DosPorUnoTest {

    @Test(expected = DosPorUnoInvalidoException.class)
    public void DosPorUnoInvalidExceptionTest() throws DosPorUnoInvalidoException {

        DosPorUno dosPorUno = new DosPorUno(new TarjetaClassic());
        dosPorUno.setProductos(new Producto("1984",60),new Producto("Un mundo feliz",90));

    }

}
