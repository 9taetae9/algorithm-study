package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TodayAlgorithm {
  public static void main(String[] args) throws IOException {
    //체스판 다시 칠하기
    //8X8로 만들 필요 있음
    //bwbw 교차
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    String[][] arr = new String[n][m];

    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split("");
      for (int j = 0; j < m; j++) {
        arr[i][j] = split[j];
      }
    }

    int min = Integer.MAX_VALUE;

    // 8x8 크기로 자를 수 있는 모든 부분 탐색
    for (int i = 0; i <= n - 8; i++) {
      for (int j = 0; j <= m - 8; j++) {
        min = Math.min(min, checkDiff(arr, i, j));
      }
    }
    System.out.println("min = " + min);
  }

  private static int checkDiff(String[][] arr, int x, int y) {
    String[] color = {"B", "W"};
    int diff1 = 0;
    int diff2 = 0;

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (!arr[x + i][y + j].equals(color[(i + j) % 2])) { //흑 맞는지
          diff1++;
        }
        if (!arr[x + i][y + j].equals(color[(i + j + 1) % 2])) { // 백 맞는지
          diff2++;
        }
      }
    }

    return Math.min(diff1, diff2);
  }

}
