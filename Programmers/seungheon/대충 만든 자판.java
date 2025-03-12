import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        List<Integer> res = new ArrayList<>();
        for (String t : targets) {
            int sum = 0;
            for (char c : t.toCharArray()) {
                int min = 987_654_321;
                for (String k : keymap) {
                    int find = k.indexOf(String.valueOf(c));

                    if (find == -1) continue;

                    min = Math.min(min, find + 1);
                }

                if (min == 987_654_321) {
                    sum = -1;
                    break;
                }
                
                sum += min;
            }
            
            res.add(sum);
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
