package org.example;

import java.util.*;

class TodayAlgorithm {
    public static void main(String[] args) {
        int[] mats = {5, 3, 2};
        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };
        System.out.println(solution(mats, park));
    }

    public static int solution(int[] mats, String[][] park) {
        int row = park.length;
        int col = park[0].length;

        List<Integer> list = Arrays.stream(mats).boxed().sorted(Collections.reverseOrder()).toList();
        int maxMat = -1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (park[i][j].equals("-1")) {
                    for (int k = 0; k < list.size(); k++) {
                        int mat = list.get(k);
                        boolean found = true;
                        if (i + mat > row || j + mat > col) {
                            continue;
                        }
                        for (int l = 0; l < mat; l++) {
                            for (int m = 0; m < mat; m++) {
                                if (!Objects.equals(park[i + l][j + m], "-1")) {
                                    found = false;
                                    break;
                                }
                            }
                            if (!found) break;
                        }
                        if (found) {
                            maxMat = Math.max(maxMat, mat);
                        }
                    }
                }
            }
        }

        return maxMat;
    }
}
