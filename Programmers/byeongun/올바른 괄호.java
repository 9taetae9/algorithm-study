package org.example;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class TodayAlgorithm {

  public static void main(String[] args) {
    //12909 - 올바른 괄호
    System.out.println(solution("())("));
  }
  public static boolean solution(String s) {
    Stack<String> stack = new Stack<>();
    Arrays.stream(s.split("")).forEach(stack::push);
    int count = 0;
    while (!stack.isEmpty()) {
      String pop = stack.pop();
      if(pop.equals("(")){
        count--;
        if(count < 0) return false;
      }else {
        count++;
      }
    }
    return count == 0;
  }
  public static boolean solution2(String s) {
    int count = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == '(') {
        count--;
        if (count < 0) return false;
      } else {
        count++;
      }
    }
    return count == 0;
  }

}
