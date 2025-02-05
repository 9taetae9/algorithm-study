import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        //정렬 후 m 단위로 자르기
        Arrays.sort(score);

        int boxes = score.length/m;

        int answer = 0;
        for(int i=1; i<=boxes; i++){
            answer += score[score.length-i*m] * m;
        }

        return answer;
    }
}


//최적화(가독성이 더 좋아보임)
import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length - m; i >= 0; i -= m)
            answer += score[i] * m;

        return answer;
    }
}
