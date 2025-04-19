import java.util.*;

class Solution {
    
    public int solution(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (!stk.isEmpty() && stk.peek() == c) {
                stk.pop();
                continue;
            }
            
            stk.push(c);
        }
        
        return stk.isEmpty() ? 1 : 0;
    }
}
