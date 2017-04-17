package ar.edu.untref.aydoo;

public class Program {
    public static void main(final String[] args) {
        try {
            PrimeNumbers primeNumbers = new PrimeNumbers();
            primeNumbers.run(args);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
