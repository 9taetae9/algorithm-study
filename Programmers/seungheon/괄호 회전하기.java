import java.util.*;

class Solution {
    
    public int solution(String s) {
        int cnt = 0;
        StringBuilder ss = new StringBuilder(s);
        for (char c : s.toCharArray()) {
            if (canRotate(ss)) cnt++;
            
            ss.append(c);
            ss.deleteCharAt(0);
        }
        
        return cnt;
    }
    
    boolean canRotate(StringBuilder ss) {
        Deque<Character> s = new ArrayDeque<>();
        for (char c : ss.toString().toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
            } else {
                if (s.isEmpty() ||
                   (s.peek() == '(' && c != ')') ||
                   (s.peek() == '{' && c != '}') ||
                   (s.peek() == '[' && c != ']')) {
                    return false;
                } else {
                    s.pop();
                }
            }
        }
        
        return s.isEmpty();
    }
}
