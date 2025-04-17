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
    //76502 - 괄호 회전하기
    System.out.println(solution("[](){}"));
  }
  public static boolean verify(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) return false;
        char top = stack.pop();
        if ((c == ')' && top != '(') ||
            (c == '}' && top != '{') ||
            (c == ']' && top != '[')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static int solution(String s) {
    int count = 0;
    String rotated = s;
    for (int i = 0; i < s.length(); i++) {
      if (verify(rotated)) {
        count++;
      }
      rotated = rotated.substring(1) + rotated.charAt(0);
    }
    return count;
  }

}
