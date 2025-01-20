class Solution {
    public int solution(String s) {
        int  cntX    = 0;
        int  cntNotX = 0;
        char x = s.charAt(0);
        
        int res = 0;
        for (char c : s.toCharArray()) {
            if (cntX == cntNotX) {
                x = c;
                res++;
            }
            
            if (c == x) cntX++;
            else        cntNotX++;
        }
        
        return res;
    }
}
