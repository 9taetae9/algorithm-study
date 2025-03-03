package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    //연속 부분 수열 합의 개수

  }
  public int solution(int[] elements) {
    Set<Integer> set = new HashSet<>();
    int n = elements.length;

    int[] newElements = new int[n * 2];
    for (int i = 0; i < n; i++) {
      newElements[i] = elements[i];
      newElements[i + n] = elements[i];
    }

    for (int length = 1; length <= n; length++) {
      for (int start = 0; start < n; start++) {
        int sum = 0;
        for (int k = 0; k < length; k++) {
          sum += newElements[start + k];
        }
        set.add(sum);
      }
    }

    return set.size();
  }

}
