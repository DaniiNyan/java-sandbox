package com.daniinyan.functioncomposition;

import java.util.function.Function;

public class SimpleFunctions {

  public static void main(String[] args) {

    Integer baseNumber = 4;
    Function<Integer, Integer> multiplyByTwo = number -> number * 2;
    System.out.println(baseNumber + " * 2 = " + multiplyByTwo.apply(baseNumber));

    Function<Integer, Integer> divideByTwo = number -> number / 2;
    System.out.println(baseNumber + " / 2 = " + divideByTwo.apply(baseNumber));

    Function<Integer, Integer> square = number -> number * number;

    System.out.println("First multiply, then square: " + multiplyByTwo.andThen(square).apply(baseNumber));
    System.out.println("First divide, then square: " + square.compose(divideByTwo).apply(baseNumber));
    System.out.println("First divide, then multiply, then square: " + divideByTwo.andThen(multiplyByTwo).andThen(square).apply(baseNumber));
    System.out.println("First multiply, then square, then divide: " + square.compose(multiplyByTwo).andThen(divideByTwo).apply(baseNumber));
  }

}
