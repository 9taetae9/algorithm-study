import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int cnt = 0;
        int n = people.length;
        // 50 50 70 80
        for (int i = 0, j = n - 1; i <= j;) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            
            j--;
            cnt++;
        }
        
        return cnt;
    }
}
