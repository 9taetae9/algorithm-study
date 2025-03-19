package org.example;

import java.util.*;
import java.io.*;

public class TodayAlgorithm {

  static int[][] bingo;
  static int count;

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    bingo = new int[5][5];
    count = 0;

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        bingo[i][j] = sc.nextInt();
      }
    }

    for (int k = 1; k <= 25; k++) {
      int num = sc.nextInt();

      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (bingo[i][j] == num)
          {
            bingo[i][j] = 0;
          }
        }
      }

      rowCheck();
      colCheck();
      lrDiagonal();
      lrDiagonal();

      if (count >= 3) {
        System.out.println(k);
        break;
      }
      count = 0;
    }
  }

  //가로 체크
  public static void rowCheck() {
    for (int i = 0; i < 5; i++) {
      int zeroCount = 0;
      for (int j = 0; j < 5; j++) {
        if (bingo[i][j] == 0) {
          zeroCount++;
        }
      }
      if (zeroCount == 5) {
        count++;
      }
    }
  }

  // 세로 체크
  public static void colCheck() {
    for (int i = 0; i < 5; i++) {
      int zeroCount = 0;
      for (int j = 0; j < 5; j++) {
        if (bingo[j][i] == 0) {
          zeroCount++;
        }
      }
      if (zeroCount == 5) {
        count++;
      }
    }
  }

  // 대각선 체크
  public static void lrDiagonal () {
    int zeroCount = 0;
    for (int i = 0; i < 5; i++) {
      if (bingo[i][i] == 0) {
        zeroCount++;
      }
    }
    if (zeroCount == 5) {
      count++;
    }
  }
  public static void rlDiagonal () {
    int zeroCount = 0;
    for (int i = 0; i < 5; i++) {
      if (bingo[i][4 - i] == 0) {
        zeroCount++;
      }
    }
    if (zeroCount == 5) {
      count++;
    }
  }
}
