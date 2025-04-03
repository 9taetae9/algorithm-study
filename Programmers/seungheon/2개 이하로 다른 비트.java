class Solution {
    public long[] solution(long[] numbers) {
        
        int l = numbers.length;
        long[] ans = new long[l];
        for (int i = 0; i < l; ++i) {
            long n = numbers[i];
            if (n % 2 == 0) {
                ans[i] = n + 1;
            } else {
                ans[i] = (n + 1) + ((n ^ (n + 1)) >> 2);
            }
        }
        
        return ans;
    }
}
