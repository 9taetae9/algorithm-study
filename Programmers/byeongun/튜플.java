package org.example;

import java.util.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    int[] result = solution("{{20,111},{111}}");
    System.out.println(Arrays.toString(result));
  }

  public static int[] solution(String s) {
    s = s.substring(2, s.length() - 2);
    String[] split = s.split("\\},\\{");
    List<List<Integer>> list = new ArrayList<>();
    for (String part : split) {
      String[] nums = part.split(",");
      List<Integer> temp = new ArrayList<>();
      for (String num : nums) {
        temp.add(Integer.parseInt(num));
      }
      list.add(temp);
    }
    list.sort(Comparator.comparingInt(List::size));
    Set<Integer> seen = new HashSet<>();
    List<Integer> result = new ArrayList<>();

    for (List<Integer> l : list) {
      for (Integer num : l) {
        if (!seen.contains(num)) {
          seen.add(num);
          result.add(num);
        }
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}
