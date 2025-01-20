import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ex140108 {
    public int solution(String s) {
        int answer = 0;
        
        int firstCharCount = 0;
        int otherCharCount = 0;
        
        char[] sCharArray = s.toCharArray();
        char firstChar = ' ';
        
        for(char c : sCharArray) {

            if(firstCharCount == 0 && otherCharCount == 0) {
                firstChar = c;
            }
            
            if(firstChar == c) {
                firstCharCount++;
            } else {
                otherCharCount++;
            }
            
            if(firstCharCount == otherCharCount) {
                answer++;
                firstCharCount = 0;
                otherCharCount = 0;
            }
        }
        

        if(firstCharCount > 0 || otherCharCount > 0) {
            answer++;
        }
        
        return answer;
    }
}
