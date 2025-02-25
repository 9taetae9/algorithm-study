import java.util.*;

class Solution {
    
    public int solution(int[] mats, String[][] park) {
        int R = park.length;
        int C = park[0].length;

        Arrays.sort(mats);
        for (int t = mats.length - 1; t >= 0; --t) {
            int m = mats[t];
            for (int i = 0; i + m <= R; ++i) {
                for (int j = 0; j + m <= C; ++j) {
                    if (isValid(i, j, m, park)) {
                        return m;
                    }
                }
            }
        }
        
        return -1;
    }

    boolean isValid(int x, int y, int m, String[][] park) {
        for (int i = x; i < x + m; ++i) {
            for (int j = y; j < y + m; ++j) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}
