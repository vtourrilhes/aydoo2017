package ar.edu.untref.aydoo.Exception;

public class DescuentoInvalidoException extends Exception {

    public DescuentoInvalidoException(){
        super("El descuento debe ser mayor o iguales a 5%");
    }

}
