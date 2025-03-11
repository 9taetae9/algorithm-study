package org.example;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

class TodayAlgorithm {

  static List<Point> points = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    int[] solution = solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"});
    for (int i : solution) {
      System.out.println("i = " + i);
    }
  }

    public static int[] solution(String[] keymap, String[] targets) {
      //각 숫자별로 가장 빠르게 접근할 수 있는 법 정렬 후
      Map<String, Integer> map = new HashMap<>();
      int count = 1;
      for (String s : keymap) {
        String[] split = s.split("");
        for (String string : split) {
          if (!map.containsKey(string)) {
            map.put(string, count);
          } else {
            map.put(string, Math.min(map.get(string), count));
          }
          count++;
        }
        count = 1;
      }
      System.out.println("map = " + map);
      int[] result = new int[targets.length];
      int num = 0;
      for (int i = 0; i < targets.length; i++) {
        String[] split = targets[i].split("");
        for (String s : split) {
          if(!map.containsKey(s)) {
            num = -1;
            break;
          }
          num += map.get(s);
        }
        result[i] = num;
        num = 0;
      }
      return result;
    }


}
