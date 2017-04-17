package ar.edu.untref.aydoo;

import java.lang.reflect.Array;

public class PrimeNumbers {

    private ArraySorter arraySorter;
    private FileSystemWriter fileSystemWriter;
    private Calculator calculator;
    private Formatter formatter;
    private Integer[] answer;

    public PrimeNumbers() {
        this.calculator = new Calculator();
        this.formatter = new Formatter();
        this.fileSystemWriter = new FileSystemWriter();
        this.arraySorter = new ArraySorter();

    }

    public void run(final String[] args) throws Exception {

        try {
            //Recibo el numero a formatear
            int recieviedNumber = Integer.parseInt(args[0]);
            answer = calculator.calculatePrimeNumbers(recieviedNumber);     //Calculo el array de resultados

            //itero el array de argumentos y hago  lo que se pide en caso de cada parametro

            for (int i = 0; i<args.length; i++) {

                if(args[i].contains("--sort=")) {
                    this.arraySorter.sortArray(args[i],answer);
                }

                if(args[i].contains("--output=")) {
                    //TODO escribir en archivo
                    //fileWritten = fileSystemWriter.makeFile(fileName);
                }

            }

            String format = args[1];
            String fileName = args[2];
            String order = "noOrder";

            //TODO obtener parametros opcionales

            String toDisplay = formatter.formatArrayNumbers(answer, format);  //recibo el String para mostrarlo

            System.out.print("Factores primos " + recieviedNumber + ": ");
            System.out.print(toDisplay);

        } catch (Exception e) {
            throw e;
        }

    }
}
