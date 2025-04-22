package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    int[] solution = solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
    for (int i : solution) {
      System.out.println("i = " + i);
    }
  }
  public static int[] solution(int[] progresses, int[] speeds) {
    List<Integer> result = new ArrayList<>();
    while (progresses.length > 0) {
      for (int i = 0; i < progresses.length; i++) {
        progresses[i] += speeds[i];
      }
      int count = 0;
      int i = 0;
      while (i < progresses.length && progresses[i] >= 100) {
        count++;
        i++;
      }
      if (count > 0) {
        result.add(count);
        progresses = Arrays.copyOfRange(progresses, count, progresses.length);
        speeds = Arrays.copyOfRange(speeds, count, speeds.length);
      }
    }
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

}
