package org.example;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
  }
  //내풀이
  public int canCompleteCircuit(int[] gas, int[] cost) {
    for (int i = 0; i < gas.length; i++) {
      int gasSize = gas[i]; //주유소에서 충전한 양
      int costSize = cost[i]; //다음 주유소까지 가는 비용
      if (gasSize < costSize) {
        continue;
      }
      int gasRemaining = gasSize;
      for (int j = i; j < i + gas.length; j++) {
        int c = j % gas.length;
        gasRemaining -= cost[c];
        if (gasRemaining < 0) {
          break;
        }
        int c2 = (j + 1) % gas.length;
        gasRemaining += gas[c2];
        if (i == (c + 1) % gas.length) {
          return i;
        }
      }
    }
    return -1;
  }
  //정답보고다시푼 풀이
  public int canCompleteCircuit2(int[] gas, int[] cost) {
    //끝나는 건 양수, 합한 값이 양수면 startNum
    int gasRemaining = 0;
    int currentgas = 0;
    int startNum = 0;
    for (int i = 0; i < gas.length; i++) {
      int balance = gas[i] - cost[i];
      gasRemaining += balance;
      currentgas += balance;
      if (currentgas < 0) {
        startNum = i + 1;  // 다음 주유소를 출발 지점으로 설정
        currentgas = 0;      // 현재 연료 초기화
      }

    }
    if(gasRemaining >= 0) { return startNum;}
    System.out.println("gas = " + gas);
    return -1;
  }


}
