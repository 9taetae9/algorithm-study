package org.example;

import java.awt.Point;
import java.util.*;
import java.io.*;

public class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    long[] solution = solution(new long[]{2, 7});
    for (long l : solution) {
      System.out.println("l = " + l);
    }
  }

  public static long[] solution(long[] numbers) {
    //N보다 크면서 비트 1~2개 바꾼 수에서 가장 작은 거
    //무조건 하나는 0 -> 1 로 변환해야 함
    // 그리고 변환 된 수 아래 중 1를 0으로 바꾸면 될 듯
    long[] answer = new long[numbers.length];
    int counter = 0;
    for (int i = 0; i < numbers.length; i++) {
      long number = numbers[i];
      String binary = Long.toBinaryString(number);
      if (!binary.contains("0")) {
        binary = "0" + binary;
      }
      char[] bits = binary.toCharArray();
      for (int j = bits.length - 1; j >= 1; j--) {
        if (bits[j - 1] == '0' && bits[j] == '1') {
          bits[j - 1] = '1';
          bits[j] = '0';
          break;
        }
      }
      String modified = new String(bits);
      answer[i] = Long.parseLong(modified, 2);
    }
    return answer;
  }

  public static long[] solution2(long[] numbers) {
    long[] answer = new long[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      long n = numbers[i];
      if (n % 2 == 0) {
        answer[i] = n + 1;
      } else {
        long bit = 1;
        while ((n & bit) != 0) { //& 연산으로 가장 작은 자리 수 0 찾음
          bit <<= 1;
        }
        answer[i] = n + bit - (bit >> 1); // 0바로 아래 1을 0으로
      }
    }
    return answer;
  }

}
