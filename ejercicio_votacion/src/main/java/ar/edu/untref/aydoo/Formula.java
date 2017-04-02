package ar.edu.untref.aydoo;


public class Formula {

    private Partido partido;
    private Candidato candidato;

    public Formula(Partido partido, Candidato candidato1) {
        this.partido = partido;
        this.candidato =  candidato1;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public Partido getPartido() {
        return partido;
    }
}
