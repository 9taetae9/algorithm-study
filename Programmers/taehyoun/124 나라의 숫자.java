import java.util.*;
class Solution {
    public String solution(int n) {
        StringBuilder sb  = new StringBuilder();
        while(n > 0){
            int r = n % 3;
            if(r == 0){
                n = n/3 - 1; 
                sb.append(4);
            }else{
                n/=3;
                sb.append(r);
            }
        }
        
        return sb.reverse().toString();
    }
}


//개선 코드
class Solution {
    public String solution(int n) {
        StringBuilder result = new StringBuilder();
        int[] digits = {4, 1, 2};
        
        while (n > 0) {
            int remainder = n % 3;
            n /= 3;

            if (remainder == 0) {
                n--; 
            }

            result.insert(0, digits[remainder]);
        }

        return result.toString();
    }
}
