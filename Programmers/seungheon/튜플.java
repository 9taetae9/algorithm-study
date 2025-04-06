import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        Map<Integer, Integer> m = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c == '{' || c == '}' || c == ',') continue;
            
            int j;
            for (j = i; j < n - 1; ++j) {
                char cc = s.charAt(j);
                if (cc == ',' || cc == '}') break;
            }
            
            int k = Integer.parseInt(s.substring(i, j));
            m.put(k, m.getOrDefault(k, 0) + 1);
            
            i = j;
        }
        
        List<Map.Entry<Integer, Integer>> l = new ArrayList(m.entrySet());
        Collections.sort(l, (e1, e2) -> {
            return Integer.compare(e2.getValue(), e1.getValue());
        });
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < l.size(); ++i) {
            res.add(l.get(i).getKey());
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
