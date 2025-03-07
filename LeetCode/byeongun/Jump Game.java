package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    //Jump Game

  }

  public boolean canJump(int[] nums) {
    int n = nums.length - 1;
    for(int i = n-1; i >=0; i--) {
      if( i+nums[i] >= n ){
        n = i;
      }
    }
    return n == 0;
  }

}
