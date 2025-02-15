package org.example;

import java.util.*;

class TodaySolution {
    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}, {3, 4}};
        System.out.println("Result : " + solution(targets));
    }

    public static int solution(int[][] targets) {
        int answer = 0;
        //1. Map으로 많이 지나가는 숫자 순(중복되면 앞에 있는 거 먼저)으로 그어보고 visited 처리
        //  - 그어 보고 닿는 미사일이 모두 visited 되었다면 pass
        //  - 개구간 처리니까 처음으로 들어가는 값은 처리하지 말자 [5,10] 에서 5는 포함 x
        //2. 각 미사일 visited 했는 지 확인
        while (true) {
            //최신화필요
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] target : targets) {
                int start = target[0];
                int end = target[1];
                for (int i = start + 1; i <= end; i++) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }

            if (map.isEmpty()) {
                break;
            }
            //가장 많이 걸친 거
            int maxOverlap = 0;
            int maxPoint = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxOverlap || (entry.getValue() == maxOverlap && entry.getKey() < maxPoint)) {
                    maxOverlap = entry.getValue();
                    maxPoint = entry.getKey();
                }
            }
            //많이 걸린 거 빼고 남는 거
            List<int[]> remainingTargets = new ArrayList<>();
            for (int[] target : targets) {
                int start = target[0];
                int end = target[1];
                if (!(start < maxPoint && maxPoint <= end)) {
                    remainingTargets.add(target);
                }
            }
            targets = remainingTargets.toArray(new int[0][]);
            answer++;
        }

        return answer;
    }
}
