//첫 코드
class Solution {
    static int ans = 0;
    static char[] chars;
    public int solution(String s) {
        chars = s.toCharArray();
        int start = 0;
        while(start < chars.length){
            char x = chars[start];
            start = nextIndex(x, start);
        }
        return ans;
    }
    
    private int nextIndex(char x, int start){
        int num = 0;
        for(int i = start; i < chars.length; i++){
            if(chars[i] == x) num++;
            else num--;
            
            if(num == 0) {
                ans++;
                return i+1;
            }
        }
        ans++;
        return chars.length;
    }
}
//개선 코드
class Solution {
    public int solution(String s) {
        int ans = 1;
        char x = s.charAt(0);
        int cnt = 1;
        
        for(int i=1; i<s.length(); i++){
            if(cnt == 0){
                ans++;
                x = s.charAt(i);
            }
            
            if(x == s.charAt(i)){
                cnt++;
            }else{
                cnt--;
            }
        }
        return ans;
    }
}
