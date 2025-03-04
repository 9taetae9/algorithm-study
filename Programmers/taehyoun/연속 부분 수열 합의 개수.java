//첫풀이 : 원형 수열임을 고려해 % 연산으로 풀기를 고민하다 번거로울거 같아 동일 배열 두개로 확장하는 방식을 선택함
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        int[] cirElements = new int[len * 2];
        System.arraycopy(elements, 0, cirElements, 0, len);
        System.arraycopy(elements, 0,cirElements, len, len);

        int[] preSum = new int[2*len +1];
        preSum[0] = 0;
        for (int i=0; i <2*len; i++) {
            preSum[i+ 1] = preSum[i] + cirElements[i];
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<len; i++) {
            for (int j=1; j<=len; j++) {
                int sum = preSum[i + j] - preSum[i];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}

//모법 답안  (시작 인덱스 + 0~길이-1) % 배열길이 
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> distinctSums = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // 길이 1부터 n까지의 연속 부분 수열의 합 계산
            for (int j = 0; j < n; j++) {
                sum += elements[(i + j) % n];
                distinctSums.add(sum);
            }
        }
        
        return distinctSums.size();
    }
}
