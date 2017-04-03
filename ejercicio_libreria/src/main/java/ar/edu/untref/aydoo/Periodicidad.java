package ar.edu.untref.aydoo;

public enum Periodicidad {
    SIN_PERIODICIDAD(1),DIARIO(31),SEMANAL(4),QUINCENAL(2),MENSUAL(1),ANUAL(1);

    private int valor;

    Periodicidad(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
