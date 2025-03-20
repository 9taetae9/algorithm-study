package org.example;

import java.util.*;
import java.io.*;

public class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    long solution = solution(8);
    System.out.println("solution = " + solution);

  }

  public static long solution(int n) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 1);
    map.put(2, 2);
    for (int i = 3; i <= n; i++) {
      int temp = (map.get(i - 1) + map.get(i - 2)) % 1234567;
      map.put(i, temp);
    }
    return map.get(n);
  }
}
