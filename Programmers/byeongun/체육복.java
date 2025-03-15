package org.example;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    int solution = solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
    System.out.println("solution = " + solution);
  }

  public static int solution(int n, int[] lost, int[] reserve) { //정확성: 73.3
    int result = n - lost.length;
    Set<Integer> wanted = new HashSet<>();

    for (int i : lost) {
      wanted.add(i - 1);
      wanted.add(i + 1);
    }
    int sum = 0;
    for (int i : reserve) {
      if (wanted.contains(i)) {
        sum++;
      }
      if (sum == lost.length) {
        break;
      }
    }
    System.out.println("sum = " + sum);
    result += sum;
    return result;
  }

  public static int solution2(int n, int[] lost, int[] reserve) {
    Set<Integer> lostSet = new HashSet<>();
    Set<Integer> reserveSet = new HashSet<>();

    for (int l : lost) {
      lostSet.add(l);
    }
    for (int r : reserve) {
      if (lostSet.contains(r)) {
        lostSet.remove(r);
      } else {
        reserveSet.add(r);
      }
    }

    for (int r : reserveSet) {
      if (lostSet.contains(r - 1)) {
        lostSet.remove(r - 1);
      } else if (lostSet.contains(r + 1)) {
        lostSet.remove(r + 1);
      }
    }

    return n - lostSet.size();
  }


}
