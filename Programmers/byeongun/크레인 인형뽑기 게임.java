package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TodayAlgorithm {
    public static void main(String[] args) {
        //크레인 인형뽑기 게임 - 64061
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int expectedResult = 4;

        int result = solution(board, moves);
        System.out.println("결과: " + result);
        System.out.println("기대값과 일치: " + (result == expectedResult));
    }

    public static int solution2(int[][] board, int[] moves) {
        int row = board.length;
        List<Stack<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = row - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    stack.push(board[j][i]);
                }
            }
            stacks.add(stack);
        }
        Stack<Integer> visited = new Stack<>();
        int bomb = 0;
        for (int move : moves) {
            if (stacks.get(move - 1).empty()) {
                continue;
            }
            Integer pop = stacks.get(move - 1).pop();
            if (!visited.isEmpty() && visited.peek().equals(pop)) {
                bomb++;
                visited.pop();
            } else {
                visited.push(pop);
            }
        }

        return bomb * 2;
    }
  public static int solution(int[][] board, int[] moves) {
        int row = board.length;
        List<Stack<Integer>> stacks = new ArrayList<>();
        for( int i=0; i<row; i++ ) {
            Stack<Integer> stack = new Stack<>();
            for (int j = row - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    stack.push(board[j][i]);
                }
            }
            stacks.add(stack);
        }
        for (Stack<Integer> stack : stacks) {
            System.out.println("stack = " + stack);
        }
        System.out.println("=========================================");
        Stack<Integer> visited = new Stack<>();
        visited.push(stacks.get(moves[0]-1).pop());
        int bomb = 0;
        for(int i=1; i<moves.length; i++){
            if(stacks.get(moves[i]-1).empty()){
                System.out.println("=========================================");
                continue;
            }
            Integer pop = stacks.get(moves[i]-1).pop();
            if(visited.peek().equals(pop)){
                bomb++;
                visited.remove(pop);
            }else {
                visited.add(pop);
            }

            System.out.println("moves = " + (moves[i]-1));
            System.out.println("pop = " + pop);
            System.out.println("visited = " + visited);
            System.out.println("bomb = " + bomb);
            System.out.println("=========================================");

        }

        System.out.println("bomb = " + bomb);
        return bomb*2;
    }


}
