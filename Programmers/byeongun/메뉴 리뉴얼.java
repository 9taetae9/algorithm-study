package org.example;

import java.util.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    String[] result = solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
    System.out.println(Arrays.toString(result));
  }

  public static String[] solution(String[] orders, int[] course) {
    Map<String, Integer> comboCount = new HashMap<>();

    for (String order : orders) {
      char[] chars = order.toCharArray();
      Arrays.sort(chars);

      for (int len : course) {
        if (len <= chars.length) {
          dfs(chars, 0, 0, len, new StringBuilder(), comboCount);
        }
      }
    }

    List<String> result = new ArrayList<>();

    for (int len : course) {
      int max = 2;
      List<String> temp = new ArrayList<>();
      for (Map.Entry<String, Integer> entry : comboCount.entrySet()) {
        if (entry.getKey().length() == len && entry.getValue() >= max) {
          if (entry.getValue() > max) {
            max = entry.getValue();
            temp.clear();
          }
          temp.add(entry.getKey());
        }
      }
      result.addAll(temp);
    }

    Collections.sort(result);
    return result.toArray(new String[0]);
  }

  private static void dfs(char[] arr, int start, int depth, int targetLen, StringBuilder sb, Map<String, Integer> map) {
    if (depth == targetLen) {
      map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
      return;
    }
    for (int i = start; i < arr.length; i++) {
      sb.append(arr[i]);
      dfs(arr, i + 1, depth + 1, targetLen, sb, map);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
