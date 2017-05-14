package ar.edu.untref.aydoo;

public class PrimeNumbers {

    private ArraySorter arraySorter;
    private Calculator calculator;
    private Formatter formatter;
    private Integer[] answer;
    private Integer[] sortedAnswer;
    private boolean writeFile;
    private String fileName;
    private String sort;

    public PrimeNumbers() {
        this.calculator = new Calculator();
        this.formatter = new Formatter();
        this.arraySorter = new ArraySorter();
        this.sort = "--sort=asc";
    }

    public void run(final String[] args) throws Exception {

        try {

            int receiviedNumber = Integer.parseInt(args[0]);

            //busco parametros opcionales en el array de argumentos
            for (int i = 0; i < args.length; i++) {
                if (args[i].contains("--sort=")) {
                    this.sort = args[i];
                }
                if (args[i].contains("--output-file=")) {
                    this.fileName = args[i].replace("--output-file=", "");
                    this.writeFile =  true;
                }
            }

            //Calculo el array de resultados
            answer = calculator.calculatePrimeNumbers(receiviedNumber);

            sortedAnswer =  this.arraySorter.sortArray(sort, answer);

            String format = args[1];

            //recibo el String para mostrarlo
            String toDisplay = formatter.formatArrayNumbers(sortedAnswer,
                                                            format);
            if (this.writeFile) {
                this.formatter.writeToFile(sortedAnswer, format,
                        fileName, receiviedNumber);
            }

            System.out.print("Factores primos " + receiviedNumber + ": ");
            System.out.print(toDisplay);

        } catch (Exception e) {
            throw e;
        }

    }
}
