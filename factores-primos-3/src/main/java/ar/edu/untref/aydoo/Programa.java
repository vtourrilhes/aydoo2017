package ar.edu.untref.aydoo;

public class Programa {
    public static void main(final String[] args) throws Exception{
        try {
            FactoresPrimos factoresPrimos = new FactoresPrimos();
            factoresPrimos.run(args);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
