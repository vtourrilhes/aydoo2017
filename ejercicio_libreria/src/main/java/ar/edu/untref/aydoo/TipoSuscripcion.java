package ar.edu.untref.aydoo;

public enum TipoSuscripcion {
    DIARIO(31),SEMANAL(4),QUINCENAL(2),MENSUAL(1),ANUAL(.80);

    private double valor;

    TipoSuscripcion(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
