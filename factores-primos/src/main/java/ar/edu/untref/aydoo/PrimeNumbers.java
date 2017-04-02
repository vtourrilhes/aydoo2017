package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;


public class PrimeNumbers {


    private Calculator calculator;
    private Formatter formatter;
    private Integer[] answer;

    public PrimeNumbers(){
        this.calculator = new Calculator();
        this.formatter = new Formatter();

    }

    public void run(String[] arg) throws Exception {

        try{
            //Recibo los parametros
            int recieviedNumber = Integer.parseInt(arg[0]);
            String format = arg[1];

            answer = calculator.calculatePrimeNumbers(recieviedNumber);     //Calculo el array de resultados
            String toDisplay = formatter.formatArrayNumbers(answer, format);  //recibo el String para mostrarlo

            //imprimo todo
            System.out.print("Factores primos "+recieviedNumber+": ");
            System.out.print(toDisplay);

        }catch (Exception e){
            throw e;
        }


    }
}
