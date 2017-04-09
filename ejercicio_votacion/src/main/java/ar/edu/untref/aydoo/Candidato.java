package ar.edu.untref.aydoo;

public class Candidato {

    private String nombre;
    private Partido partido;

    public Candidato(String nombre,Partido partido){
        this.nombre = nombre;
        this.partido = partido;
    }

    public String getNombre() {
        return nombre;
    }
    public Partido getPartido() {
        return partido;
    }
}
