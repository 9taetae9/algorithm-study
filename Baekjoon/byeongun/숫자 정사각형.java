package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class TodayAlgorithm {
    public static void main(String[] args) throws IOException {
        // 숫자 정사각형 - 1051
        // 한 줄 읽었을 떄 같은 숫자가 나온다면 즉시 내려가 정사각형 꼭짓점 위치에 같은 수가 있는 지 확인
        // 한 줄에 같은 숫자 2개 이상 있을 수 있음 줄은 끝까지 다 읽어봐야 함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] charArrays = new char[n][m];
        for (int i = 0; i < n; i++) {
            charArrays[i] = br.readLine().toCharArray();
        }
        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c1 = charArrays[i][j];
                for (int k = j + 1; k < m; k++) {
                    if (c1 == charArrays[i][k]) {
                        int diff = k - j;
                        if (i + diff < n && j + diff < m) {
                            char c3 = charArrays[i + diff][j];
                            char c4 = charArrays[i + diff][j + diff];
                            if (c1 == c3 && c1 == c4) {
                                max = Math.max(max, (diff + 1) * (diff + 1));
                            }

                        }
                    }
                }
            }

        }
        System.out.println("max = " + max);

    }
}
