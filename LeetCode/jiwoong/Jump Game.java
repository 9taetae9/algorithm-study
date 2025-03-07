class Solution {
    public boolean canJump(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > ans) {
                return false;
            }
            ans = Math.max(ans, i + nums[i]);
            if (ans >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
