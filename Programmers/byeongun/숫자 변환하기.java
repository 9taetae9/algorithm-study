package org.example;

import java.util.*;

class TodaySolution {
    //154538 - 숫자 변환하기
    public static void main(String[] args) {
        int solution = solution(10, 40, 5);
        System.out.println("solution = " + solution);
    }
    static int min = Integer.MAX_VALUE;
    static Set<Integer> visited = new HashSet<>();

    public static int solution(int x, int y, int n) {
        //최소 연산 횟수
        //x -> y , x+n, x*2, x*3
        //느낌으로는 DFS일 거 같은데
        if (x == y) return 0;
        dfs(x, 0, y, n);
        System.out.println("visited = " + visited);
        if(min == Integer.MAX_VALUE) min = -1;
        return min;
    }
    public static int bfs(int current, int y, int n){
        if(current == y) return 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new int[]{current, 0});
        visited.add(current);

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int value = cur[0];
            int count = cur[1];

            int[] nextValues = {value*3, value*2, value+n}; //미리 계산
            for (int nextValue : nextValues) {
                if(nextValue == y){ return count+1; }
                if(nextValue < y && !visited.contains(nextValue)){
                    queue.add(new int[]{nextValue, count+1});
                    visited.add(nextValue);
                }
            }
        }
        return -1;
    }
    public static void dfs(int current, int count, int y, int n) {
        if (current == y) {
            min = Math.min(min, count);
            return;
        }
        if (current > y ) return;
        if (min <= count &&  visited.contains(current)) return;

        visited.add(current);

        dfs(current * 3, count + 1, y, n);
        dfs(current * 2, count + 1, y, n);
        dfs(current + n, count + 1, y, n);

    }
}
