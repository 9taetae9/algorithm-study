import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; ++i) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10_007;
        }
        
        System.out.print(dp[n]);
    }
}
