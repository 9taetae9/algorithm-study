package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    //124나라
    solution(7);
  }

  public static String solution(int n) {
    String[] num = {"4", "1", "2"};
    StringBuilder answer = new StringBuilder();

    while (n > 0) {
      int remainder = n % 3;
      n = (n - 1) / 3;
      answer.insert(0, num[remainder]);
    }

    return answer.toString();
  }
}
