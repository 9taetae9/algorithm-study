package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class TodayAlgorithm {
    public static void main(String[] args) throws IOException {
        //동전 0 - 11047
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bf.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int goal = Integer.parseInt(split[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int coins = Integer.parseInt(bf.readLine());
            list.add(coins);
        }
        int coins = 0;
        for(int i=list.size()-1; i>=0; i--) {
            if(list.get(i) <= goal) {
                System.out.println("list.get(i) = " + list.get(i));
                coins += (goal/list.get(i));
                goal %= list.get(i);
            }
        }
        System.out.println("coins = " + coins);
    }


}
