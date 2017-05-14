package ar.edu.untref.aydoo.Exception;

public class DosPorUnoInvalidoException extends Exception {

   public DosPorUnoInvalidoException(){
     super("El precio minimo de alguno de los dos productos debe ser superior a 100 pesos");
   }

}
