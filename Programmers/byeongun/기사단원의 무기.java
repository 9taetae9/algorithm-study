package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    //136798 - 기사단원의 무기
    //System.out.println(solution(10,3,2));
    test(10,3,2);
  }

  public static int solution(int number, int limit, int power) {
    //number limit power
    int sum = 0;
    for(int i=1; i<number+1; i++){
      int strength = countDivisions(i);
      if(strength > limit) sum += power;
      else{
        sum+=strength;
      }
      System.out.println("strength = " + strength);
    }
    return sum;
  }
  public static int countDivisions(int number){
    //절반까지만 구하면 됨
    if(number == 1) return 1;
    int count = 0;
    for(int i = 1; i<=number/2; i++){
      if( i*i == number){
        count++;
      } else if( number % i == 0){
        count++;
      }
    }
    return count+1;
  }
  public static void test(int number, int limit, int power) {
    int[] count = new int[number + 1];
    for (int i = 1; i <= number; i++) {
      for (int j = 1; j <= number / i; j++) {
        if( i == 2 ) {
          System.out.println("i*j = " + i * j);
        }
        count[i * j]++;
      }
    }
    for (int i : count) {
      System.out.println(i);
    }

  }





}
