import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> t = new HashMap<>();
        for (int i = 0; i < name.length; ++i) {
            t.put(name[i], yearning[i]);
        }
        
        int n = photo.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            for (String p : photo[i]) {
                int v = t.getOrDefault(p, 0);
                sum += v;
            }
            res[i] = sum;
        }
        
        return res;
    }
}
