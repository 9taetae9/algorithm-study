package org.example;

import java.util.*;
import java.io.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    solution(80, new int[][]{{80,20},{50,40},{30,10}});
    //{{78, 18}, {70, 11}, {67, 9}, {60, 8}, {59, 2}, {57, 54}}
    //{{80,20},{50,40},{30,10}}
  }
  static boolean[] visited;
  static int max = Integer.MIN_VALUE;
  public static int solution(int k, int[][] dungeons) {
    visited = new boolean[dungeons.length];
    dfs(k, dungeons, 0);
    System.out.println("max = " + max);
    return max;
  }

  private static void dfs(int k, int[][] dungeons, int count) {
    max = Math.max(max, count);
    for(int i = 0; i < dungeons.length; i++) {
      if(k < dungeons[i][0] || visited[i]) {
        continue;
      }
      visited[i] = true;
      dfs(k-dungeons[i][1], dungeons, count+1);
      visited[i] = false;
    }
  }
}
