package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TodayAlgorithm {
    public static void main(String[] args) {
        // 추억 점수 - 176963
        // 첫 번째 테스트 케이스
        String[] names1 = {"may", "kein", "kain", "radi"};
        int[] scores1 = {5, 10, 1, 3};
        String[][] photos1 = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        // 두 번째 테스트 케이스
        String[] names2 = {"kali", "mari", "don"};
        int[] scores2 = {11, 1, 55};
        String[][] photos2 = {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}};

        // 세 번째 테스트 케이스
        String[] names3 = {"may", "kein", "kain", "radi"};
        int[] scores3 = {5, 10, 1, 3};
        String[][] photos3 = {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}};

        System.out.println(Arrays.toString(solution(names1, scores1, photos1)));
        System.out.println(Arrays.toString(solution(names2, scores2, photos2)));
        System.out.println(Arrays.toString(solution(names3, scores3, photos3)));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        //이름이 있는 지 없는 지 확인해서 있는 것은 yearning에 따라 더함
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        int sum;
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            sum = 0;
            for(int j = 0; j < photo[i].length; j++) {
                sum += map.getOrDefault(photo[i][j], 0);
            }
            if(sum < 0){
                continue;
            }
            answer[i] = sum;
        }

        for (int i : answer) {
            System.out.print(i+" ");
        }

        return answer;
    }
}
