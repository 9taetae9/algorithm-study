import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        Deque<Integer> q1 = new ArrayDeque<>(n * 2);
        Deque<Integer> q2 = new ArrayDeque<>(n * 2);
        
        long sum = 0;
        long q1Sum = 0, q2Sum = 0;
        for (int i = 0; i < n; ++i) {
            int e1 = queue1[i], e2 = queue2[i];
            
            q1Sum += e1;
            q2Sum += e2;
            sum += e1 + e2;
            q1.offerLast(e1);
            q2.offerLast(e2);
        }
        sum /= 2;
        
        int cnt = 0;
        while (cnt < 2 * n * 2) {
            if (q2Sum == sum && q1Sum == sum) {
                break;
            }
            
            if (q1Sum > sum) {
                int e = q1.pollFirst();
                q2.offerLast(e);
                q1Sum -= e;
                q2Sum += e;
                cnt++;
            }
            
            if (q2Sum > sum) {
                int e = q2.pollFirst();
                q1.offerLast(e);
                q2Sum -= e;
                q1Sum += e;
                cnt++;
            }
        }
        
        return q1Sum == q2Sum ? cnt : -1;
    }
}
