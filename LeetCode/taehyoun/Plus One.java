class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i>=0; i--){
            if(digits[i]+1 == 10){
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
        }
    
        int[] n_digits = new int[digits.length+1];
        n_digits[0] = 1;
        System.arraycopy(n_digits,1, digits,0,digits.length);
        return n_digits;
    }
}
