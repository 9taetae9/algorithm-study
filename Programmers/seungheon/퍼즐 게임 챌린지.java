class Solution {
    int[] diffs; int n; int[] times; long limit;
    
    boolean canSolve(int level) {
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            if (sum > limit) return false;
            
            if (diffs[i] > level) {
                sum += (times[i] + times[i - 1]) * (diffs[i] - level) + times[i];
                continue;
            }

            sum += times[i];
        }
    
        return sum <= limit;
    };
    
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs; this.n = diffs.length; this.times = times; this.limit = limit;
        
        int left = 1, right = 100_000;
        int level = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canSolve(mid)) {
                level = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return level;
    }
}
