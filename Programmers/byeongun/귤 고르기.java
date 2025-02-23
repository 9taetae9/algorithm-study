package org.example.weekend3;

import java.util.*;

public class study1 {
    public static void main(String[] args) {
        solution(6 , new int[]{1, 3, 2, 5, 4, 5, 2, 3});
    }

    public static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        System.out.println("map = " + map);
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        System.out.println("list = " + list);
        int sum = 0;
        int count = 0;
        for (Integer i : list) {
            sum += i;
            count++;
            if( sum >= k){
                break;
            }
        }
        return count;

    }

}
