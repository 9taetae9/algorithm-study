import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        Set<String> s = new HashSet<>();
        
        int x = 0, y = 0;
        for (char d : dirs.toCharArray()) {
            
            int xx = x, yy = y;
            if      (d == 'U' && y + 1 <= 5)  yy++;
            else if (d == 'D' && y - 1 >= -5) yy--;
            else if (d == 'R' && x + 1 <= 5)  xx++;
            else if (d == 'L' && x - 1 >= -5) xx--;
            else continue;
            
            s.add(x + "," + y + ":" + xx + "," + yy);
            s.add(xx + "," + yy + ":" + x + "," + y);
            
            x = xx;
            y = yy;
        }
        
        return s.size() / 2;
    }
}
