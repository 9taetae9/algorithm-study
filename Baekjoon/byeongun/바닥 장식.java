package org.example;

import java.util.*;
import java.io.*;

public class TodayAlgorithm {
  static int N;
  static int M;
  static boolean[][] visited;
  static String[][] floor;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] split = br.readLine().split(" ");
    N = Integer.parseInt(split[0]);
    M = Integer.parseInt(split[1]);
    visited = new boolean[N][M];
    floor = new String[N][M];
    for(int i = 0; i < N; i++) {
      String[] splitRead = br.readLine().split("");
      for(int j = 0; j < M; j++) {
        floor[i][j] = splitRead[j];
      }
    }
    System.out.println("N = " + N);
    System.out.println("M = " + M);
    for (String[] strings : floor) {
      for (String string : strings) {
        System.out.print(string+" ");
      }
      System.out.println();
    }
    int result = 0;
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {

        if(floor[i][j].equals("-") && !visited[i][j]) {
          System.out.println("i + \", j = \" + j = " + i + ", j = " + j);

          rowCheck(i,j);
          result++;
        }
        if(floor[i][j].equals("|") && !visited[i][j]) {
          System.out.println("i + \", j = \" + j = " + i + ", j = " + j);

          colCheck(i,j);
          result++;
        }
      }
    }
    System.out.println(result);
  }

  private static void rowCheck(int i, int j) {
    if (i < 0 || j < 0 || i >= N || j >= M || visited[i][j] || !floor[i][j].equals("-")) {
      return;
    }
    visited[i][j] = true;
    rowCheck(i, j + 1);
  }

  private static void colCheck(int i, int j) {
    if (i < 0 || j < 0 || i >= N || j >= M || visited[i][j] || !floor[i][j].equals("|")) {
      return;
    }
    visited[i][j] = true;
    colCheck(i + 1, j);
  }
}
