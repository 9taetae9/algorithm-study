package org.example;

import java.util.Arrays;

class TodayAlgorithm {
    public static void main(String[] args) {
        // 구명보트 - 42885
        solution(new int[]{70, 50, 50, 30}, 100);
    }

    public static int solution(int[] people, int limit) {
        int start = 0;
        int end = people.length - 1;
        int[] sortedPeople = Arrays.stream(people).sorted().toArray();
        int count = 0;

        while (start <= end) {
            int big = sortedPeople[end];
            if (sortedPeople[start] + big <= limit) {
                start++;
            }
            end--;
            count++;
        }

        System.out.println("count = " + count);
        return count;
    }
}
