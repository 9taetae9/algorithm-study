//첫 시도 : 문제 이해 잘못함 => 2명 제한 고려 안함
//채점 결과
//정확성: 55.6
//효율성: 18.5
//합계: 74.1 / 100.0
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        int sum = people[right];
        int cnt = 1;
        while(left <= right){
            if(sum + people[left] <= limit){
                sum = sum + people[left];
                left++;
            }else{
                right--;
                sum = people[right];
                cnt++;
            }
        }
        
        return cnt;
    }
}

//채점 결과
//정확성: 81.5
//효율성: 18.5
//합계: 100.0 / 100.0
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        int sum = people[right];
        int cnt = 0;
        while(left < right){
            if(sum + people[left] <= limit){
                sum = sum + people[left];
                left++;
                right--;
                sum = people[right];
                cnt++;
            }else{
                right--;
                sum = people[right];
                cnt++;
            }
        }

        return (left==right) ? cnt+1 : cnt;
    }
}
