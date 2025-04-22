package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TodayAlgorithm {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int N = split[0];
    int K = split[1];
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();
    for(int i=1; i<=N; i++){
      queue1.offer(i);
    }
    while(queue1.size() > 1){
      for(int i=1; i<K; i++){
        queue1.offer(queue1.poll());
      }
      queue2.add(queue1.poll());
    }
    queue2.add(queue1.poll());
    StringBuilder sb = new StringBuilder();
    sb.append("<");
    while(queue2.size() > 1){
      sb.append(queue2.poll());
      sb.append(", ");
    }
    sb.append(queue2.poll());
    sb.append(">");
    System.out.println("sb = " + sb);
  }
}
