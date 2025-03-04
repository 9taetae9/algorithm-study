class Solution {
    
    int[] otf = { 1, 2, 4 };
    int m = otf.length;
    
    public String solution(int n) {
        
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            res.insert(0, otf[(n - 1) % m]);
            n = (n - 1) / m;
        }
        
        return res.toString();
    }
    
    
}
