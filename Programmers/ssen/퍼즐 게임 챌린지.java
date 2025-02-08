public class Solution {
    public static long solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        int left = 1, right = 100000;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (canSolveWithinLimit(diffs, times, mid, limit)) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        return left;
    }

    private static boolean canSolveWithinLimit(int[] diffs, int[] times, int level, long limit) {
        long totalTime = 0;
        int n = diffs.length;
        
        for (int i = 0; i < n; i++) {
            int timeCur = times[i];
            int timePrev = (i == 0) ? 0 : times[i - 1];
            int mistakes = Math.max(0, diffs[i] - level);
            
            totalTime += mistakes * (timeCur + timePrev) + timeCur;
            
            if (totalTime > limit) {
                return false;
            }
        }
        return true;
    }
}
