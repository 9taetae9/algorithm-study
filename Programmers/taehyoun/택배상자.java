//내 풀이
import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=order.length; i>0; i--){
            stack.push(i);
        }
        
        int res = 0;
        Deque<Integer> stack2 = new ArrayDeque<>();
        for(int num : order){
            while(true){
                if(!stack.isEmpty() && stack.peek() == num){
                    stack.pop();
                    res++;
                    break;
                }else if(!stack2.isEmpty() && stack2.peek() == num){
                    stack2.pop();
                    res++;
                    break;
                }else{
                    if(stack.isEmpty()) return res;
                    int n = stack.pop();
                    stack2.push(n);
                }
            }
        }
        return res;
    }
}

//GPT 풀이 - 공부용
/*
1. 컨테이너 벨트를 위한 스택은 굳이 필요 없다.(증가하는 변수로 대체) => 연속된 수열, 다시 컨테이너 벨트로 상자를 옮겨 담는 경우가 없기 때문
2. 보조 벨트에 있는 상자를 확인하는 시점은 컨테이너 벨트에서 원하는 벨트를 트럭에 담은 직후이다.
=> 컨테이너 벨트에서 원하는 벨트를 못 찾았을 경우 보조 벨트에 원하는 상자가 있는지 확인하는 로직은 불필요하다.
=> 보조 벨트에 있는 상자들은 현재 desiredIndex를 만족하지 않았기 때문이다. 
*/
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int solution(int[] order) {
        int n = order.length;
        int desiredIndex = 0;  // 기사님이 원하는 다음 상자 번호를 가리키는 인덱스
        Deque<Integer> stack = new ArrayDeque<>();  // 보조 컨테이너 벨트 (LIFO)

        // 메인 컨테이너 벨트에서 상자는 1부터 n까지 순서대로 나온다.
        for (int box = 1; box <= n; box++) {
            // 현재 상자가 기사님이 원하는 상자면 바로 트럭에 싣는다.
            if (box == order[desiredIndex]) {
                desiredIndex++;
                // 트럭에 싣은 후, 보조 벨트의 맨 위 상자가
                // 현재 원하는 순서의 상자와 일치하면 계속해서 트럭에 싣는다.
                while (!stack.isEmpty() && desiredIndex < n && stack.peek() == order[desiredIndex]) {
                    stack.pop();
                    desiredIndex++;
                }
            } else {
                // 현재 상자가 원하는 상자가 아니라면 보조 벨트에 임시 보관한다.
                stack.push(box);
            }
            // 만약 모든 상자를 싣은 경우 반복을 종료한다.
            if (desiredIndex == n) break;
        }
        // 트럭에 실은 상자의 개수를 반환한다.
        return desiredIndex;
    }
}

