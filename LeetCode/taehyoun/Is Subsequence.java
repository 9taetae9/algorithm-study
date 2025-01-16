class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        int dirs = 0;
        int dirt = 0;
        
        int sLen = s.length();
        int tLen = t.length();

        while(dirs < sLen && dirt < tLen){
            if(cs[dirs] == ct[dirt]){
                dirs++; dirt++;
            }else{
                dirt++;
            }
        }

        return dirs == sLen;
    }
}
