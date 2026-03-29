package com.blitz.dynamic_programming.dp.memoization;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

/**
 * class shares the implementation of Fibonacci sequence in 
 * recursive optimised and unoptimised implementation
 * @author blitz
 */
public class Fibonacci {
  /**
   * optimised Fibonacci sequence implementation with recursion
   * @param num number whose fibonacci sequence value we want to calculate
   * @return the fibonacci sequence value of the number
   */
  public static int getFibonacciOptimised(int num) {
    return getFibonacciOptimised(num, new HashMap<Integer, Integer>());
  }

  /**
   * @param num number whose fibonacci sequence value we want to calculate
   * @param map hash-map of fibonacci values of the numbers
   * @return the fibonacci value of the number
   */
  public static int getFibonacciOptimised(int num, Map<Integer, Integer> map) {
    if (map.containsKey(num)) {
      return map.get(num);
    } else {
      if (num == 0 || num == 1) {
        map.put(num, num);
        return num;
      } else {
        map.put(num, getFibonacciOptimised(num - 1, map) + getFibonacciOptimised(num - 2, map));
        return map.get(num);
      }
    }
  }

  /**
   * unoptimised recursive Fibonacci sequence calculation
   * @param num number whose fibonacci sequence value we want to calculate
   * @return the fibonacci value of the number
   */
  public static int getFibonacci(int num) {
    if (num == 0) {
      return 0;
    } else if (num == 1) {
      return 1;
    } else {
      return getFibonacci(num - 1) + getFibonacci(num - 2);
    }
  }

  public static void main(String[] args) {
    int[] fibArr = new int[10];
    for (int i = 0; i < fibArr.length; i++) {
      fibArr[i] = getFibonacci(i);
    }
    System.out.println(Arrays.toString(fibArr));
    int num = 150;
    System.out.println("\n\nfibonacci (optimised) of " + num + ": " + getFibonacciOptimised(num));
    System.out.print("fibonacci (un-optimised) of " + num + ": ");
    try {
      System.out.println(getFibonacci(num));
    } catch (Exception exp) {
      System.out.println("\n" + exp.getClass().getSimpleName() +
          " was triggered with the below message:\n\t" + exp.getMessage());
    } finally {
      System.out.println("===================");
      System.out.println("execution completed");
      System.out.println("===================");
    }
  }
}
