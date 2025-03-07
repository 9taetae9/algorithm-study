class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int k = 2, i = 2;
        while (i < n) {
            if (nums[k - 2] != nums[i]) {
                nums[k++] = nums[i];
            }

            i++;
        }

        return k;
    }
}
