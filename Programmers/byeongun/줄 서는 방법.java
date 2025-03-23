package org.example;

import java.util.*;
import java.io.*;

public class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    // 12936 - 줄 서는 방법

    int[] solution = solution(3, 5);
  }

  public static int[] solution(int n, long k) {
    int startNum = 0;
    for (int i = 1; i <= n; i++) {
      startNum = startNum * 10 + i;
    }
    int endNum = 0;
    for (int i = n; i >= 1; i--) {
      endNum = endNum * 10 + i;
    }
    List<Integer> result = new ArrayList<>();
    while (startNum <= endNum) {
      String thisNum = String.valueOf(startNum);
      List<String> list = new ArrayList<>();
      for (String s : thisNum.split("")) {
        list.add(s);
      }
      boolean flag = false;
      for (int i = 1; i <= n; i++) {
        if (!list.contains(String.valueOf(i))) {
          flag = true;
        }
      }
      if(!flag) {
        result.add(startNum);
      }
      startNum++;
    }
    System.out.println("result = " + result);
    Integer resultNum = result.get((int) k-1);
    System.out.println("resultNum = " + resultNum);
    return Arrays.stream(resultNum.toString().split("")).mapToInt(Integer::parseInt)
        .toArray();
  }
  public int[] solution2(int n, long k) {
    int[] answer = new int[n];
    ArrayList<Integer> ary = new ArrayList<>();

    //총 경우의 수 n!
    long total = 1;
    for(int i=1;i<=n;i++)
    {
      ary.add(i);
      total *= i;
    }
    //배열의 인덱스는 0부터 시작하여 찾아야될 번호를 -1
    k--;

    int idx = 0;
    while(idx < n)
    {
      //전체 경우의 수 / 숫자의 갯수
      total /= n - idx;
      //해당 인덱스의 값의 숫자 가져오기
      answer[idx++] = ary.remove((int) (k/total));
      //다음 찾아야될 번호
      k %= total;

    }
    return answer;
  }

}
