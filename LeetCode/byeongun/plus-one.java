package org.example;

import java.util.*;
import java.io.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    //https://leetcode.com/problems/plus-one/
    int[] ints = plusOne(new int[]{1,2});
    for (int anInt : ints) {
      System.out.println("anInt = " + anInt);
    }
  }

  public static int[] plusOne(int[] digits) {
    if(digits[0] == 9){
      int[] temp = new int[digits.length+1];
      temp[0] = 0;
      for(int i = 1; i < digits.length+1; i++){
        temp[i] = digits[i-1];
      }
      digits = temp;
    }
    int overNum = 0;
    boolean flag = false;

    for(int i= digits.length-1; i >= 0; i--){
      if(flag) continue;
      if(digits[i] == 9){
        overNum++;
        digits[i] = 0;
      }else {
        if(overNum == 0){
          digits[i]++;
        }else {
          digits[i]++;
        }
        flag = true;
      }
    }
    if(digits[0] == 0){
      digits = Arrays.copyOfRange(digits, 1, digits.length);
    }
    return digits;
  }
}
