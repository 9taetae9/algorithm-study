import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder res = new StringBuilder("0");
        for (int i = food.length - 1; i > 0; --i) {
            int f = food[i];
            
            for (int j = 0; j < f / 2; ++j) {
                res.append((char)(i + '0'));
            }
            
            for (int j = 0; j < f / 2; ++j) {
                res.insert(0, (char)(i + '0'));
            }
        }
        
        return res.toString();
    }
}
