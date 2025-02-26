import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int cnt = 0;
        while (true) {
            int sB = Math.min(bill[0], bill[1]);
            int mB = Math.max(bill[0], bill[1]);
            int sW = Math.min(wallet[0], wallet[1]);
            int mW = Math.max(wallet[0], wallet[1]);
            
            if (sB <= sW && mB <= mW) break;
            
            if (bill[0] == mB) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            
            cnt++;
        }
        
        return cnt;
    }
}
