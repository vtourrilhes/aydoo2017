package ar.edu.untref.aydoo;

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
            //Recibo el numero a formatear
            int recieviedNumber = Integer.parseInt(args[0]);
            //Calculo el array de resultados
            answer = calculator.calculatePrimeNumbers(recieviedNumber);

            //busco parametros opcionales en el array de argumentos
            for (int i = 0; i < args.length; i++) {
                if (args[i].contains("--sort=")) {
                   sortedAnswer =  this.arraySorter.sortArray(args[i], answer);
                }
                if (args[i].contains("--output=")) {
                    this.fileName = args[i].replace("--output=", "") + ".txt";
                    this.writeFile =  true;
                }
            }

            String format = args[1];

            //recibo el String para mostrarlo
            String toDisplay = formatter.formatArrayNumbers(sortedAnswer,
                                                            format);
            if (this.writeFile) {
                this.formatter.writeToFile(sortedAnswer, format,
                        fileName, recieviedNumber);
            }

            System.out.print("Factores primos " + recieviedNumber + ": ");
            System.out.print(toDisplay);

        } catch (Exception e) {
            throw e;
        }

    }
}
