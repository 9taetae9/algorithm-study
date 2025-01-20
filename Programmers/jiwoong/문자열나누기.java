class Solution {
    public int solution(String s) {
        int ans = 0;
        int targetCnt = 0;
        int otherCnt = 0;


        for (int i = 0; i < s.length(); i++) {

            if (targetCnt == 0) {
                targetCnt++;
            } else if (s.charAt(i) == s.charAt(i - targetCnt - otherCnt)) {
                targetCnt++;
            } else {
                otherCnt++;
            }


            if (targetCnt == otherCnt) {
                ans++;
                targetCnt = 0;
                otherCnt = 0;
            }
        }

        if (targetCnt != 0) {
            ans++;
        }

        return ans;
    }
}