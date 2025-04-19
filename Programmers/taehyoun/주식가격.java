//시간 복잡도: O(n^2)
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++){
            int sec = 0;
            for(int j=i+1; j<n; j++){
                sec++;
                if(prices[j] < prices[i]){
                    break;
                }
            }
            answer[i] = sec;
        }
        
        return answer;
    }
}

//최적 O(n) 스택 활용
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            //현재 시점 i를 스택에 추가
            stack.push(i);
        }
        
        //스텍에 남은 인덱스들은 끝까지 하락이 없었던 것
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = n - idx - 1;
        }
        
        return answer;
    }
}
