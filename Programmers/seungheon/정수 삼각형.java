class Solution {
    public int solution(int[][] triangle) {
        
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; ++i) {
            
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            for (int j = 1; j <= i; ++j) {
                if (j == i) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        
        int max = 0;
        for (int m : dp[n - 1]) {
            max = Math.max(max, m);
        }
        
        return max;
    }
}

/*
7           7
3 8         10 15
8 1 0       18 max(11 16) 15
2 7 4 4     20 max(25, 23) max(20, 19) 19
*/
