package org.example;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class TodayAlgorithm {

  public static void main(String[] args) {
    //12973 - 짝지어 제거하기
    int solution = solution("cdcd");
    System.out.println("solution = " + solution);
  }

  public static int solution(String s) {
    Stack<String> stack = new Stack<>();
    for ( String string : Arrays.stream(s.split("")).toArray(String[]::new)) {
      if(stack.isEmpty()) stack.push(string);
      else if(stack.peek().equals(string)){
        stack.pop();
      }else {
        stack.push(string);
      }
    }
    return stack.isEmpty()?1:0;
  }

}
