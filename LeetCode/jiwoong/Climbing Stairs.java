class Solution{
    public int climbStairs(int n) {
        int[] dp = new int[46];

        dp[0] = 1; dp[1] = 1; dp[2] = 2; dp[3] = 3; dp[4] = 5;

        for(int i = 5; i<dp.length; i++){
            dp[i]  = dp[i - 1] + dp[i - 2];
            if (i == n) return dp[i];
        }

        return dp[n];
    }
}