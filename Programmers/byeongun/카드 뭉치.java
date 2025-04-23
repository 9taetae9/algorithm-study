package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    String solution = solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"},
        new String[]{"i", "want", "to", "drink", "water"});
    System.out.println("solution = " + solution);
  }

  public static String solution(String[] cards1, String[] cards2, String[] goal) {
    Queue<String> card1 = new ArrayDeque<>();
    Queue<String> card2 = new ArrayDeque<>();
    for (String s : cards1) {
      card1.add(s);
    }
    for (String s : cards2) {
      card2.add(s);
    }
    int count = 0;
    for (String s : goal) {
      if (!card1.isEmpty() && card1.peek().equals(s)) {
        card1.poll();
      } else if (!card2.isEmpty() && card2.peek().equals(s)) {
        card2.poll();
      } else {
        return "No";
      }
    }
    return "Yes";
  }
}
