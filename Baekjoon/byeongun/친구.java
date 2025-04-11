package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    char[][] friendList = new char[N][N];
    for (int i = 0; i < N; i++) {
      friendList[i] = br.readLine().toCharArray();
    }

    int max = 0;
    for (int i = 0; i < N; i++) {
      boolean[] visited = new boolean[N];
      for (int j = 0; j < N; j++) {
        if (i == j) continue;

        if (friendList[i][j] == 'Y') {
          visited[j] = true;
        } else {
          for (int k = 0; k < N; k++) {
            if (friendList[i][k] == 'Y' && friendList[k][j] == 'Y') {
              visited[j] = true;
              break;
            }
          }
        }
      }
      int count = 0;
      for (boolean b : visited) {
        if (b) count++;
      }
      max = Math.max(max, count);
    }
    System.out.println(max);
  }
}
