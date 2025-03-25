//첫 시도
/*
정확성: 88.2
합계: 88.2 / 100.0
*/
class Solution
{
    public int solution(int n, int a, int b)
    {
        return getRound(a,b);
    }
    
    private int getRound(int a, int b){
        int r = 1;
        while(Math.abs(a-b) != 1){
            if(a %2 == 0){
                a/=2;
            }else{
                a++;
                a/=2;
            }
            if(b%2 == 0){
                b/=2;
            }else{
                b++;
                b/=2;
            }
            r++;
        }
        return r;
    }
}

//두번째 (통과)
/*
a,b 작은 것을 왼쪽 인자로 넘기기
종료 조건
1차이이면서, a(작은쪽)가 홀수여야함 => 위쪽 코드에서는 1차이만 고려해서 2,3번이 만날수 있는것으로 판단하여 오답 
*/
class Solution
{
    public int solution(int n, int a, int b)
    {
        return getRound(a < b ? a : b, a >= b ? a : b);
    }
    
    private int getRound(int a, int b){
        int r = 1;
        while(!(b-a == 1 && a % 2 == 1)){
            if(a %2 == 0){
                a/=2;
            }else{
                a++;
                a/=2;
            }
            if(b%2 == 0){
                b/=2;
            }else{
                b++;
                b/=2;
            }
            r++;
        }
        return r;
    }
}

//최적 코드 (인터넷)
class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }
}
