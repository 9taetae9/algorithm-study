package org.example;

import java.util.Arrays;

class TodayAlgorithm {
    public static void main(String[] args) {
        //퍼즐 게임 챌린지 -340212
        int[][] diffs = {
                {1, 5, 3},
                {1, 4, 4, 2},
                {1, 328, 467, 209, 54},
                {1, 99999, 100000, 99995}
        };
        int[][] times = {
                {2, 4, 7},
                {6, 3, 8, 2},
                {2, 7, 1, 4, 3},
                {9999, 9001, 9999, 9001}
        };
        long[] limits = {30, 59, 1723, 3456789012L};
        int[] expectedResults = {3, 2, 294, 39354};

        for (int i = 0; i < 4; i++) {
            int result = solution(diffs[i], times[i], limits[i]);
            System.out.println("Test case " + (i + 1) + ":");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expectedResults[i]);
            System.out.println(result == expectedResults[i] ? "PASS" : "FAIL");
            System.out.println();
        }
    }
    public static int solution(int[] diffs, int[] times, long limit) {
        // 이진 탐색으로 level 찾기
        int low = 1;
        int high = Arrays.stream(diffs).max().getAsInt();
        int resultLevel = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long currResult = logic(diffs, times, mid);
            System.out.println("mid = " + mid);
            System.out.println("currResult = " + currResult);
            if (currResult <= limit) {
                resultLevel = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return resultLevel;
    }

    public static long logic(int[] diffs, int[] times, int level) {
        long sum = 0;
        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int curr = times[i];
            if (i == 0) {
                sum += curr;
                continue;
            }
            int prev = times[i - 1];
            sum += calculate(diff, level, curr, prev);
        }
        return sum;
    }

    public static int calculate(int diff, int level, int curr, int prev) {
        int i = diff - level;
        if (i > 0) {
            curr = curr + (curr + prev) * i;
            return curr;
        } else
            return curr;
    }
    public static int solution2(int[] diffs, int[] times, long limit) {
        //문제 느낌이 Divide and Conquer 같은데 각 퍼즐 순서마다 값을 저장해놓고 필요할 때 꺼내서 써보자
        //숙련도의 최솟값을 정수 리턴
        //시작 레벨을 어떻게 시작하냐가 관건인거 같음

        //limit 보다 크면서 제일 작은 수 (
        // level이 작을수록 result값은 커짐 )
        int level = Arrays.stream(diffs).sum() / diffs.length;
        System.out.println("level = " + level);
        int progressive = 1;
        boolean found = false;
        long storedResult = 0;
        while (found == false) {
            System.out.println("level = " + level);

            long currResult = logic(diffs, times, level);
            System.out.println("currResult = " + currResult);

            long prevResult = logic(diffs, times, level - 1);
            System.out.println("prevResult = " + prevResult);

            if (currResult <= limit && prevResult > limit) found = true;
            else if (currResult < limit && prevResult < limit) { // 현재 값이 한계값보다 작은데 ( 현재 마이너스 필요 ) , 이전 값도 작음
                level -= progressive;
                storedResult = currResult;
                progressive++;
            } else if (currResult > limit && storedResult < limit) { //현재값이 한계 값보다 큰데 ( 현재 플러스 필요 ) , 현재 이전 값은 작음 -> 뺐더니 역전됨
                progressive = 1;
                storedResult = currResult;
                level++;
            } else if ( currResult >  limit) {
                level += progressive;
                storedResult = currResult;
                progressive++;
            }
        }
        return level;
    }

}
