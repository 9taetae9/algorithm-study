package org.example;

import java.awt.Point;
import java.util.*;
import java.io.*;

public class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    //2512 - 예산
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int m = Integer.parseInt(br.readLine());
    // m에 제일 근접한 수 찾기-> 이분탐색?

    Arrays.sort(arr);
    int start = arr[0];
    int end = arr[arr.length - 1];
    int tax;
    Point point = new Point(0, 0); // 차이, 목표 수
    for(int i = start; i <= end; i++) {
      tax = i;
      int sum = 0;
      for (int j = 0; j < arr.length; j++) {
        if( tax < arr[j]){
          sum += tax;
        }else {
          sum += arr[j];
        }
      }
      if (sum <= m) {
        point.x = sum;
        point.y = i;
      } else {
        break;
      }
    }
    System.out.println(point.y);
  }

}
