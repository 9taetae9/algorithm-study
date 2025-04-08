import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> s = new TreeSet<>();
        int n = numbers.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                s.add(numbers[i] + numbers[j]);
            }
        }
        
        return s.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
