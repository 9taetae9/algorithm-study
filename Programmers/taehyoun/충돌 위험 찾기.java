// 첫코드  일부 테스트 케이스 통과 - (메모리 초과,런티임 에러 발생)
/*
3차원 배열로 모든 시간,좌표 관리 - 고정 크기 배열로 비효율적
 */
public class Solution  {
    public int solution(int[][] points, int[][] routes) {
        int[][][] countMap = new int[101][101][101]; //[time][r][c]
        int collision = 0;

        for (int i = 0; i < routes.length; i++) {
            int time = 0;

            for (int j = 0; j < routes[i].length - 1; j++) {
                int[] start = points[routes[i][j] - 1];
                int[] end = points[routes[i][j + 1] - 1];

                int curR = start[0], curC = start[1];
                int nextR = end[0], nextC = end[1];

                while (curR != nextR) {
                    if (countMap[time][curR][curC] == 1) collision++;
                    countMap[time][curR][curC]++;
                    curR += (curR < nextR) ? 1 : -1;
                    time++;
                }

                while (curC != nextC) {
                    if (countMap[time][curR][curC] == 1) collision++;
                    countMap[time][curR][curC]++;
                    curC += (curC < nextC) ? 1 : -1;
                    time++;
                }
            }

            int lastR = points[routes[i][routes[i].length - 1] - 1][0];
            int lastC = points[routes[i][routes[i].length - 1] - 1][1];
            if (countMap[time][lastR][lastC] == 1) collision++;
            countMap[time][lastR][lastC]++;
        }

        return collision;
    }
}


//개선 코드
/*
HashMap<String, Integer>를 사용하여 필요한 시간과 좌표만 동적으로 저장
각 시간(time), 좌표(r, c)를 문자열 형태로 키를 만들어 기록하므로, 실제로 로봇이 이동한 경로만 기록
메모리를 과도하게 할당하지 않으므로 고정 사이즈 배열보다 효율적
 */
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[][] points, int[][] routes) {
        Map<String, Integer> countMap = new HashMap<>(); // "time_r_c"를 키로 사용
        int collision = 0;

        for (int i = 0; i < routes.length; i++) {
            int time = 0; // 각 로봇마다 개별 시간 추적

            for (int j = 0; j < routes[i].length - 1; j++) {
                int[] start = points[routes[i][j] - 1];
                int[] end = points[routes[i][j + 1] - 1];

                int curR = start[0], curC = start[1];
                int nextR = end[0], nextC = end[1];

                // r 좌표 이동
                while (curR != nextR) {
                    String key = time + "_" + curR + "_" + curC; // 고유한 키 생성
                    countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                    if (countMap.get(key) == 2) { // 충돌 조건 (2대 이상 로봇 모이는 경우)
                        collision++;
                    }
                    curR += (curR < nextR) ? 1 : -1;
                    time++;
                }

                // c 좌표 이동
                while (curC != nextC) {
                    String key = time + "_" + curR + "_" + curC;
                    countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                    if (countMap.get(key) == 2) {
                        collision++;
                    }
                    curC += (curC < nextC) ? 1 : -1;
                    time++;
                }
            }

            // 마지막 포인트 체크
            int lastR = points[routes[i][routes[i].length - 1] - 1][0];
            int lastC = points[routes[i][routes[i].length - 1] - 1][1];
            String key = time + "_" + lastR + "_" + lastC;
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            if (countMap.get(key) == 2) {
                collision++;
            }
        }

        return collision;
    }
}
