package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public Integer[] calculatePrimeNumbers(int recieviedNumber) {

        if(recieviedNumber==1) return new Integer[]{1};
        List<Integer> numbersList = new ArrayList<>();

        while(recieviedNumber!=1){
            int answer = getLeastPrimeFactor(recieviedNumber);
            numbersList.add(answer);
            recieviedNumber = recieviedNumber/answer;
        }

        Integer[] arrayAnswer = new Integer[numbersList.size()];
        arrayAnswer = numbersList.toArray(arrayAnswer);
        return arrayAnswer;
    }

    public static int getLeastPrimeFactor(int number){

        int answer=2;

        while(number%answer!=0){
            answer++;
        }

        return answer;
    }
}
