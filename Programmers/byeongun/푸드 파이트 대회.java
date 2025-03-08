package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    //134240 - 푸드 파이트 대회
    
    String solution = solution(new int[]{1, 3, 4, 7});
    System.out.println("solution = " + solution);
  }
  public static String solution(int[] food) throws IOException {
    int water = 0;
    StringBuilder front = new StringBuilder();
    int init = 1;
    for(int i = 1; i < food.length; i++) {
      int num = (int) (double) (food[i] / 2);
      for(int j = 0; j < num; j++) {
        front.append(init);
      }
      init++;
    }
    StringBuilder back = new StringBuilder();
    String[] split = front.toString().split("");
    for( int i = split.length - 1; i >= 0; i--) {
      back.append(split[i]);
    }
    front.append(water);
    front.append(back);
    return front.toString();
  }




}
