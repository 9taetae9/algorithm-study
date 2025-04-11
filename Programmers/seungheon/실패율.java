import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        Map<Integer, Integer> m = new HashMap<>();
        for (int s : stages) {
            m.put(s, m.getOrDefault(s, 0) + 1);
        }
        
        int t = stages.length;
        Map<Integer, Double> m2 = new HashMap<>();
        for (int i = 1; i <= N; ++i) {
            
            int v = m.getOrDefault(i , 0);
            double rate = t == 0 ? 0 : (double)v / t;
            
            m2.put(i, rate);
            t -= v;
        }
        
        List<Map.Entry<Integer, Double>> l = new ArrayList<>(m2.entrySet());
        Collections.sort(l, (e1, e2) -> {
            if (e1.getValue() == e2.getValue()) {
                return Integer.compare(e1.getKey(), e2.getKey());
            }
            
            return Double.compare(e2.getValue(), e1.getValue());
        });
        
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); ++i) {
            res[i] = l.get(i).getKey();
        }
        
        return res;
    }
}
