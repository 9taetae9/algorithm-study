package org.example;

import java.util.*;

public class TodayAlgorithm {
  public static void main(String[] args) {
    solution(new int[]{2,1,3,4,1});
  }

  // 이 부분을 변경해서 실행해보세요.
  public static int[] solution(int[] numbers) {
    List<Integer> list = new ArrayList<>();
    for(int i = 0; i<numbers.length-1; i++){
      for(int j = i+1; j<numbers.length; j++){
        list.add(numbers[j]+numbers[i]);
      }
    }
    Collections.sort(list);
    return list.stream().distinct().mapToInt(i->i).toArray();
  }

}
