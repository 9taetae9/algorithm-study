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
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    List<Integer> list1 = new ArrayList<>();
    for (String s : br.readLine().split(" ")) {
      Integer parseInt = Integer.parseInt(s);
      list1.add(parseInt);
    }
    List<Integer> list = new ArrayList<>(list1);
    list.sort(Integer::compareTo);
    int sum = 0;
    int result = 0;
    for(int i = 0; i < N; i++) {
      sum = (list.get(i)+sum);
      result += sum;
    }
    System.out.println(result);

  }


}
