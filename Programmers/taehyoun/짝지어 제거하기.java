/**채점 결과
정확성: 61.2
효율성: 0.0
합계: 61.2 / 100.0
*/

class Solution
{
    
    public int solution(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        boolean change = true;
        
        while(change){
            int prevLen = sb.length();
            int i = 0;
        
            while(i < sb.length() - 1){
                if(sb.charAt(i) == sb.charAt(i+1)){
                    sb.delete(i,i+2);
                }else{
                    i++;
                }
            }
            change = prevLen != sb.length();
        }
        return sb.length() == 0 ? 1: 0;
    }
    
    
}

//스택 통과 코드
import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        
        return stack.isEmpty() ? 1: 0;
    }
}
