/*채점 결과
정확성: 70.4(시간초과)
합계: 70.4 / 100.0*/
class Solution {
    public int solution(int number, int limit, int power) {
        int res = 0;
        for(int i=1; i <=number; i++){
            int e = calculate(i);
            if(e > limit){
                res += power;
            }else{
                res += e;
            }
        }
        
        return res;
    }
    
    private int calculate(int number){
        int n = 0;
        for(int i=1; i<=number; i++){
            if(number%i == 0) n++;
        }
        return n;
    }
}

//통과
class Solution {
    public int solution(int number, int limit, int power) {
        int res = 0;
        for(int i=1; i <=number; i++){
            int e = calculate(i);
            if(e > limit){
                res += power;
            }else{
                res += e;
            }
        }
        
        return res;
    }
    
    private int calculate(int number){
        boolean odd = false;
        if(number == 1) return 1;
        int n = 0;
        for(int i=1; i*i<=number; i++){
            if(number%i == 0) n++;
            if(i*i == number) odd = true;
        }
        return odd ? n*2-1 : n*2;
    }
}
