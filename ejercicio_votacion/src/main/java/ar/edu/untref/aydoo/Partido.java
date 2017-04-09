package ar.edu.untref.aydoo;

import java.util.List;
import java.util.LinkedList;

public class Partido {

    private String nombre;
    private List<Candidato> candidatos;

    public Partido(String nombre) {
        this.nombre = nombre;
        this.candidatos = new LinkedList<Candidato>();
    }

    public void agregarCandidato(Candidato candidato){
        this.candidatos.add(candidato);
    }

    public String getNombre() {
        return nombre;
    }
}
