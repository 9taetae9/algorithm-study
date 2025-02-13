import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> c = new ArrayDeque<>();
        for (int i = 1; i <= order.length; ++i) {
            c.offerLast(i);
        }
        
        Deque<Integer> subC = new ArrayDeque<>();
        int cnt = 0;
        int i = 0;
        while (i < order.length) {
            int o = order[i];
            
            if (!subC.isEmpty() && o == subC.peekFirst()) {
                subC.pollFirst();
                cnt++;
                i++;
                continue;
            }
            
            if (!c.isEmpty() && o == c.peekFirst()) {
                c.pollFirst();
                cnt++;
                i++;
                continue;
            }
            
            if (!c.isEmpty()) {
                subC.offerFirst(c.pollFirst());
                continue;
            }
            
            break;
        }
        
        return cnt;
    }
}
