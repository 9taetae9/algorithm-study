package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    //https://school.programmers.co.kr/learn/courses/30/lessons/131127
    int solution = solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                                      new int[]{3, 2, 2, 2, 1},
        new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana",
            "pork", "rice", "pot", "banana", "apple", "banana"});
    System.out.println("solution = " + solution);
  }

  public static int solution(String[] want, int[] number, String[] discount) {
    Map<String, Integer> wantMap = new HashMap<>();
    for (int i = 0; i < want.length; i++) {
      wantMap.put(want[i], number[i]);
    }

    int answer = 0;
    for (int i = 0; i <= discount.length - 10; i++) {
      Map<String, Integer> discountMap = new HashMap<>();
      for (int j = i; j < i + 10; j++) {
        discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
      }

      boolean success = true;
      for (String item : wantMap.keySet()) {
        if (discountMap.getOrDefault(item, 0) < wantMap.get(item)) {
          success = false;
          break;
        }
      }
      if (success) {
        answer++;
      }
    }

    return answer;
  }
}
