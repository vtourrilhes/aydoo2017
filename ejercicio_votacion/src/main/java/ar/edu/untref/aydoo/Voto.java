package ar.edu.untref.aydoo;

public class Voto {

    private Candidato candidato;
    private Provincia provincia;

    public Voto(Candidato candidato, Provincia provincia) {
        this.candidato = candidato;
        this.provincia = provincia;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public Provincia getProvincia() {
        return provincia;
    }

}
