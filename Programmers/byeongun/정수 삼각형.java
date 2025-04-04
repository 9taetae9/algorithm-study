package org.example;

import java.awt.Point;
import java.util.*;
import java.io.*;

public class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    //43105 - 정수 삼각형
    int solution = solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
    System.out.println("solution = " + solution);
  }
  public static int solution(int[][] triangle) {
    int depth = triangle.length;
    for(int i = depth - 2; i >= 0; i--) {
      for(int j=0; j<triangle[i].length; j++) {
        triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
      }
    }
    return triangle[0][0];
  }


}
