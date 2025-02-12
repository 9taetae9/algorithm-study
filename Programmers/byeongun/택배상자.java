package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

class TodayAlgorithm {
    public static void main(String[] args) {
        //택배상자 - 131704
        int solution = solution(new int[]{4, 3, 1, 2, 5});
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] order) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= order.length; i++) queue.add(i);
        System.out.println("queue = " + queue);
        System.out.println("=================================");
        int count = 0;
        for (Integer x : order) {
            System.out.println("x = " + x);
            while (!queue.isEmpty() || !stack.isEmpty()){
                if(!queue.isEmpty() && queue.peek().equals(x)){
                    count ++;
                    System.out.println("queue = " + queue);
                    System.out.println("stack = " + stack);
                    queue.poll();
                    System.out.println("=================================");
                    break;
                }else if(!stack.isEmpty() && stack.peek().equals(x)){
                    count ++;
                    System.out.println("queue = " + queue);
                    System.out.println("stack = " + stack);
                    System.out.println("=================================");
                    stack.pop();
                    break;
                }else if (!queue.isEmpty()) {
                    stack.push(queue.poll());
                    System.out.println("queue = " + queue);
                    System.out.println("stack = " + stack);
                    System.out.println("=================================");
                }else {
                    return count;
                }
            }
        }
        System.out.println("count = " + count);

        return count;
    }

}
