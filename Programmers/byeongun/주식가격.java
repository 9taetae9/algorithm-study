package org.example;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class TodayAlgorithm {

  public static void main(String[] args) {
    //42584 - 주식가격
    int[] solution = solution(new int[]{1, 2, 3, 2, 3});
    for (int i : solution) {
      System.out.println("i = " + i);
    }
  }

  public static int[] solution(int[] prices) {
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[prices.length];
    for (int i = 0; i < prices.length; i++) {
      while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
        int top = stack.pop();
        result[top] = i - top;
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      int top = stack.pop();
      result[top] = prices.length - 1 - top;
    }
    return result;
  }

}
