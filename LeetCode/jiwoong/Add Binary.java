class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int c = 0;

        while( i>= 0 || j >=0){
            int sum = c;
            if(i >= 0){
                sum += a.charAt(i) - '0';
                i--;
            }
            if( j>=0){
                sum +=b.charAt(j) - '0';
                j--;
            }

            if(sum > 1  ) c = 1;
            else c = 0;
            ans.append(sum%2);
        }

        if(c > 0 ) ans.append(c);
        return ans.reverse().toString();
    }
}