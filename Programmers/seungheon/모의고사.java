import java.util.*;

class Solution {
    static int[] pattern1 = { 1, 2, 3, 4, 5 };
    static int[] pattern2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
    static int[] pattern3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
    
    public int[] solution(int[] answers) {
        
       int[] cnt = new int[3];
        for (int i = 0; i < answers.length; ++i) {
            int a = answers[i];
            if (pattern1[i % pattern1.length] == a) {
                cnt[0]++;
            }
            if (pattern2[i % pattern2.length] == a) {
                cnt[1]++;
            }
            if (pattern3[i % pattern3.length] == a) {
                cnt[2]++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        for (int i = cnt.length - 1; i >= 0; --i) {
            if (cnt[i] >= max) {
                res.add(0, i + 1);
            }
        }
        
        return res.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
