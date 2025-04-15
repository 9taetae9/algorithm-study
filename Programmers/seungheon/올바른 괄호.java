class Solution {
    String ss;
    
    boolean solution(String s) {
        ss = s;
        return ans(0, 0);
    }
    
    boolean ans(int cnt, int i) {
        if (cnt < 0) return false;
        
        if (i == ss.length()) return cnt == 0;
        
        if (ss.charAt(i) == '(') cnt++;
        else                     cnt--;
        
        return ans(cnt, i + 1);
    }
}
