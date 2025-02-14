package org.example;

import java.awt.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class TodayAlgorithm {
    public static void main(String[] args) {
        //두 큐 합 같게 만들기 - 118667
        int[] queue1_1 = {3, 2, 7, 2};
        int[] queue2_1 = {4, 6, 5, 1};
        System.out.println("Result 1: " + solution(queue1_1, queue2_1)); // Expected: 2

        // 테스트 케이스 2
        int[] queue1_2 = {1, 2, 1, 2};
        int[] queue2_2 = {1, 10, 1, 2};
        System.out.println("Result 2: " + solution(queue1_2, queue2_2)); // Expected: 7

        // 테스트 케이스 3
        int[] queue1_3 = {1, 1};
        int[] queue2_3 = {1, 5};
        System.out.println("Result 3: " + solution(queue1_3, queue2_3)); // Expected: -1
    }

    public static int solution(int[] queue1, int[] queue2) {
        //1안. BFS?
        //2안. 목표 값과의 차를 이용해 각 배열 검색하면서 차이를 맞출 수 있는 지 확인
        int queue1Sum = Arrays.stream(queue1).sum();
        int queue2Sum = Arrays.stream(queue2).sum();
        Queue<Integer> q1 = new ArrayDeque<>();
        for (int i : queue1) {
            q1.add(i);
        }
        Queue<Integer> q2 = new ArrayDeque<>();
        for (int i : queue2) {
            q2.add(i);
        }
        int target = (queue1Sum + queue2Sum) / 2;
        System.out.println("target = " + target);

        int maxOperations = (queue1.length + queue2.length) * 2;
        int operation = 0;
        while (operation < maxOperations) {
            if(queue1Sum == target) {
                return operation;
            }
            if(queue1Sum > target) {
                Integer poll = q1.poll();
                queue1Sum -= poll;
                queue2Sum += poll;
                q2.add(poll);
            }else {
                Integer poll = q2.poll();
                queue1Sum += poll;
                queue2Sum -= poll;
                q1.add(poll);
            }
            operation++;
        }
        return operation;
    }

}
