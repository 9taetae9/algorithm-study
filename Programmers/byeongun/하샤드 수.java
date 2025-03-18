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

    boolean solution = solution(71);
    System.out.println("solution = " + solution);
  }
  public static boolean solution(int x) {
    String s = String.valueOf(x);
    List<Integer> list = new ArrayList<>();
    for (String string : s.split("")) {
      Integer parseInt = Integer.parseInt(string);
      list.add(parseInt);
    }
    int sum = 0;
    for(int i=0; i<list.size(); i++){
      sum += list.get(i);
    }
    if(x%sum == 0) return true;
    return false;
  }


}
