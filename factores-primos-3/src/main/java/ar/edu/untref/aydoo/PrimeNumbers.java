package ar.edu.untref.aydoo;

import java.lang.reflect.Array;

public class PrimeNumbers {

    private ArraySorter arraySorter;
    private Calculator calculator;
    private Formatter formatter;
    private Integer[] answer;
    private Integer[] sortedAnswer;
    private boolean writeFile;
    private String fileName;

    public PrimeNumbers() {
        this.calculator = new Calculator();
        this.formatter = new Formatter();
        this.arraySorter = new ArraySorter();

    }

    public void run(final String[] args) throws Exception {

        try {

            int recieviedNumber = Integer.parseInt(args[0]);  //Recibo el numero a formatear
            answer = calculator.calculatePrimeNumbers(recieviedNumber); //Calculo el array de resultados

            //busco parametros opcionales en el array de argumentos
            for (int i = 0; i<args.length; i++) {
                if(args[i].contains("--sort=")) {
                   sortedAnswer =  this.arraySorter.sortArray(args[i],answer);
                }
                if(args[i].contains("--output=")) {
                    this.fileName = args[i].substring(9) + ".txt";
                    this.writeFile =  true;
                }
            }

            String format = args[1];

            String toDisplay = formatter.formatArrayNumbers(sortedAnswer, format);  //recibo el String para mostrarlo

            if(this.writeFile) {
                this.formatter.writeToFile(sortedAnswer, format,fileName,recieviedNumber);
            }

            System.out.print("Factores primos " + recieviedNumber + ": ");
            System.out.print(toDisplay);

        } catch (Exception e) {
            throw e;
        }

    }
}
