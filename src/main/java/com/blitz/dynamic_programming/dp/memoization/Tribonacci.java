package com.blitz.dynamic_programming.dp.memoization;

import java.util.HashMap;
import java.util.Map;

/**
 * this class is the solution for leetcode-1137
 * it finds the Fibonacci for a particular number
 */
public class Tribonacci {
  /**
   * the below implementation is to find the fibonacci number with dynamic-programming
   * relations provided:
   *    * Tn+3 = Tn + Tn+1 + Tn+2
   *    * T0 = 0, T1 = 1, T2 = 1
   * @param int num
   * @return the tribonacci value of the num
   */
  private static int getTribonacci(int num) {
    /*
     * substitute n with (n - 3) then the provided relation becomes:
     * Tn = Tn-3 + Tn-2 + Tn-1
     */
    return getTribonacci(num, new HashMap<Integer, Integer>()); /* a fast data structure object is passed to 
      cache the values which were calculated to not do the same calculations multiple times*/
  }

  /**
   * below is the implementation of the dynamic-programming
   * a <em>Map</em> object is passed to retain the memoization (cacheing)
   * @param int num
   * @param Map<Integer, Integer> map
   * @return the tribonacci result of the number
   */
  private static int getTribonacci(int num, Map<Integer, Integer> map) {
    if (map.containsKey(num)) {
      return map.get(num);
    } else {
      if (num == 1 || num == 2) {
        return 1;
      } else if (num == 0) {
        return num;
      }  else {
        map.put(num, getTribonacci(num - 3, map) + getTribonacci(num - 2, map) + getTribonacci(num - 1, map)); 
        return map.get(num);
      }
    }
  }

  public static void main(String[] args) {
    int num = 4;
    System.out.println("tribonacci sequence of " + num + ": " + getTribonacci(num));
    num = 25;
    System.out.println("tribonacci sequence of " + num + ": " + getTribonacci(num));
  }
}
