import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> s = new HashSet<>();
        int n = elements.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = 0;
                for (int k = j; k <= j + i; ++k) {
                    sum += elements[k % n];
                }
                s.add(sum);
            }
        }
        
        return s.size();
    }
}
