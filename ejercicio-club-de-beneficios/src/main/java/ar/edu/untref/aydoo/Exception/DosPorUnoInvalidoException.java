package ar.edu.untref.aydoo.Exception;

/**
 * Created by Valentin Tourrilhes on 18/4/2017.
 */
public class DosPorUnoInvalidoException extends  Exception{

   public DosPorUnoInvalidoException(){
     super("El precio minimo de alguno de los dos productos debe ser superior a 100 pesos");
   }

}
