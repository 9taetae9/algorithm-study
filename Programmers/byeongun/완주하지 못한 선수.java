package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    String solution = solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
    System.out.println("solution = " + solution);
  }

  public static String solution(String[] participant, String[] completion) {
    HashMap<String, Integer> map = new HashMap<>();
    for (String name : participant) {
      map.put(name, map.getOrDefault(name, 0) + 1);
    }
    for (String name : completion) {
      map.put(name, map.get(name) - 1);
    }
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 0) {
        return entry.getKey();
      }
    }
    return null;
  }
}
