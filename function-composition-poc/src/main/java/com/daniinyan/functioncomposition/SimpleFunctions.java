package com.daniinyan.functioncomposition;

import java.util.function.Function;

public class SimpleFunctions {

  public static void main(String[] args) {

    Integer baseNumber = 4;
    Function<Integer, Integer> multiplyByTwo = number -> number * 2;
    System.out.println(baseNumber + " * 2 = " + multiplyByTwo.apply(baseNumber));

    Function<Integer, Integer> divideByTwo = number -> number / 2;
    System.out.println(baseNumber + " / 2 = " + divideByTwo.apply(baseNumber));

  }

}
