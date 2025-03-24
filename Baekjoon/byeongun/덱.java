package org.example;

import java.util.*;
import java.io.*;

public class TodayAlgorithm {

  static Deque<Integer> deque = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String[] split = br.readLine().split(" ");
      switch (split[0]) {
        case "push_back":
          pushBack(Integer.parseInt(split[1]));
          break;
        case "push_front":
          pushFront(Integer.parseInt(split[1]));
          break;
        case "pop_front":
          popFront();
          break;
        case "pop_back":
          popBack();
          break;
        case "size":
          size();
          break;
        case "empty":
          empty();
          break;
        case "front":
          front();
          break;
        case "back":
          back();
          break;
      }
    }
  }

  public static void pushBack(int num) {
    deque.offerLast(num);
  }

  public static void pushFront(int num) {
    deque.offerFirst(num);
  }

  public static void popFront() {
    if (deque.isEmpty()) {
      System.out.println("-1");
    } else {
      System.out.println(deque.pollFirst());
    }
  }

  public static void popBack() {
    if (deque.isEmpty()) {
      System.out.println("-1");
    } else {
      System.out.println(deque.pollLast());
    }
  }

  public static void size() {
    System.out.println(deque.size());
  }

  public static void empty() {
    System.out.println(deque.isEmpty() ? 1 : 0);
  }

  public static void front() {
    if (deque.isEmpty()) {
      System.out.println("-1");
    } else {
      System.out.println(deque.peekFirst());
    }
  }

  public static void back() {
    if (deque.isEmpty()) {
      System.out.println("-1");
    } else {
      System.out.println(deque.peekLast());
    }
  }
}
