class Solution {
    public int solution(int number, int limit, int power) {
        int res = 0;
        for (int n = 1; n <= number; ++n) {
            int divisor = calcDivisor(n);
            if (divisor > limit) {
                res += power;
                continue;
            }
            
            res += divisor;
        }
        
        return res;
    }
    
    int calcDivisor(int num) {
        int cnt = 0;
        for (int i = 1; i * i <= num; ++i) {
            if (i * i == num) cnt++;
            else if (num % i == 0) cnt += 2;
        }
        
        return cnt;
    }
}
