import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (int[] a, int[] b) -> {
            return a[1] - b[1];
        });
        
        int n = targets.length;
        int cnt = 0;
        for (int i = 0, j = 1; i < n && j < n;) {
            if (targets[i][1] <= targets[j][0]) {
                i = j++;
                cnt++;
                continue;
            }
            
            j++;
        }
        cnt++;
        
        return cnt;
    }
}
