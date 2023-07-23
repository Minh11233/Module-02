package com.codegym;

public class FizzBuzz {
    boolean isFizz = number % 3 == 0;
    boolean isBuzz = number % 5 == 0;
    public static String fizzBuzz(int number){
        if(isFizz && isBuzz)
            return "FizzBuzz";

        if(isFizz)
            return "Fizz";

        if(isBuzz)
            return "Buzz";

        return number + "";
    }
}
