import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int maxProfit = 0;
        int n = score.length;
        for (int i = n - m; i >= 0; i -= m) {
            maxProfit += score[i] * m;
        }
        return maxProfit;
    }
    
    
    
}
