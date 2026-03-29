package com.blitz.dynamic_programming.dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class Factorial {
  private static int getFactorial(int num) {
    if (num == 0 || num == 1) {
      return num;
    } else {
      return num * getFactorial(num - 1);
    }
  }

  private static int getFactorialOptimised(int num) {
    return getFactorialOptimised(num, new HashMap<Integer, Integer>());
  }

  private static int getFactorialOptimised(int num, Map<Integer, Integer> map) {
    if (num == 0 || num == 1) {
      return 1;
    } else if (map.containsKey(num)) {
      return map.get(num);
    } else {
      int result = num * getFactorialOptimised(num - 1, map);
      map.put(num, result);

      return result;
    }
  }

  public static void main(String[] args) {
      int num = 5;
    System.out.println("factorial of 5: " + getFactorial(num));
    System.out.println("factorial of 5: " + getFactorialOptimised(num));
  }
}
