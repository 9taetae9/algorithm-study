package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    //42889 - 실패율
    solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
  }

  public static int[] solution(int N, int[] stages) {
    //스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    //실패율이 높은 스테이지부터 내림차순
    //n : N개의 스테이지 수 , stages 각 사람들의 깨야할 스테이지
    //N+1 스테이지에 있는 사람 N까지의 스테이지 완료

    int[] challengers = new int[N + 2]; // 각 스테이지에 도달한 사람 수

    for (int stage : stages) {
      challengers[stage]++;
    }

    int totalPlayers = stages.length;
    Map<Integer, Double> stageList = new HashMap<>();

    for (int i = 1; i <= N; i++) {
      int failed = challengers[i];
      double failureRate = totalPlayers == 0 ? 0 : (double) failed / totalPlayers;
      stageList.put(i, failureRate);
      totalPlayers -= failed;
    }

    return stageList.entrySet().stream()
        .sorted((e1, e2) -> {
          int cmp = Double.compare(e2.getValue(), e1.getValue());
          if (cmp == 0) {
            return Integer.compare(e1.getKey(), e2.getKey());
          }
          return cmp;
        })
        .mapToInt(Map.Entry::getKey)
        .toArray();
  }

}
