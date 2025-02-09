package org.example;

import java.util.*;

class TodaySolution {
    public static void main(String[] args) {
        int result1 = solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}});
        int result2 = solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}});
        int result3 = solution(new int[]{4, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}});
        int result4 = solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}});
        int solution = solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}});

        System.out.println(result1); // 5
        System.out.println(result2); // -1
        System.out.println(result3); // -1
        System.out.println(result4); // 3
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int count = attacks[attacks.length - 1][0]+1;
        boolean[] attackTiming = new boolean[count];
        Queue<Integer> attack = new ArrayDeque<>();
        for (int[] ints : attacks) {
            attackTiming[ints[0]-1] = true;
            attack.add(ints[1]);
        }
        int hp = health;
        int consecutiveTry = 0;
        int skillDelay = bandage[0];
        int healingBySec = bandage[1];
        int skillHealing = bandage[2];

        for (int i = 1; i < count; i++) {
            if(attackTiming[i-1]){
                hp -= attack.poll();
                if(hp <= 0){return -1;}
                consecutiveTry = 0;
                continue;
            }
            consecutiveTry++;
            hp = healing(hp, healingBySec, health);
            if(consecutiveTry == skillDelay){
                hp = healing(hp, skillHealing, health);
                consecutiveTry = 0;
            }
            System.out.println("timely hp = " + hp);

            //System.out.println("consecutiveTry = " + consecutiveTry);
        }

        return hp;
    }

    public static int healing(int hp, int skillHealing, int maxHealth) {
        return Math.min(hp + skillHealing, maxHealth);
    }

}
