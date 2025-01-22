package org.example;

import java.util.Arrays;

public class TodaySolution {
    public static void main(String[] args) {
        solution solution1 = new solution();
        int[][] land = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };
        int result = solution1.solution(land);
        System.out.println("oilMax = " + result);
    }
}

class solution {
    int n;
    int m;
    int[][] directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    boolean[][] visited;

    public int solution(int[][] land) {
        int totalOil = 0;
        n = land.length; // 세로 크기
        m = land[0].length; // 가로 크기
        visited = new boolean[n][m]; // 방문 여부 저장
        int[] oils = new int[m];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (land[c][r] == 1 && !visited[c][r]) {
                    int oil = dfs(land, c, r);
                    totalOil += oil;
                }
            }
            oils[r] = totalOil;
            totalOil = 0;
            visited = new boolean[n][m];
        }

        return Arrays.stream(oils).max().getAsInt();
    }

    public int dfs(int[][] land, int c, int r) {
        if (c < 0 || c >= n || r < 0 || r >= m || land[c][r] == 0 || visited[c][r]) {
            return 0;
        }

        visited[c][r] = true;
        int count = 1;

        // 4방향 탐색 (오른손 법칙 순서로)
        for (int[] direction : directions) {
            int newC = c + direction[0];
            int newR = r + direction[1];
            count += dfs(land, newC, newR);
        }

        return count;
    }
}
