package org.example;

import java.util.*;
import java.io.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    //https://leetcode.com/problems/single-number/
    int i = singleNumber2(new int[]{2, 2, 1});
    System.out.println("i = " + i);
  }
  
  public static int singleNumber(int[] nums) {
    Queue<Integer> queue = new LinkedList<>();
    for (int num : nums) {
      if(queue.contains(num)){
        queue.remove(num);
        continue;
      }
      queue.offer(num);
    }
    System.out.println("queue = " + queue);
    return queue.poll();
  }

  //정답
  public static int singleNumber2(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result ^= num;
    }
    return result;
  }
}
