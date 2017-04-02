package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Partido {

    private String nombre;
    private List<Formula> formulas;

    public Partido(String nombre) {
        this.nombre = nombre;
        this.formulas = new LinkedList<Formula>();
    }

    public void agregarFormula(Formula formula){
        this.formulas.add(formula);
    }

    public String getNombre() {
        return nombre;
    }
}
