package ar.edu.untref.aydoo;

public class Voto {

    private Formula formula;
    private Provincia provincia;

    public Voto(Formula formula, Provincia provincia) {
        this.formula = formula;
        this.provincia = provincia;
    }

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}
