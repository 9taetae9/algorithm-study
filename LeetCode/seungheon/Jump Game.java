class Solution {
    public boolean canJump(int[] nums) {
        int jump = 0;
        for (int n : nums) {
            if (jump < 0) return false;

            jump = Math.max(jump, n);

            jump--;
        }

        return true;
    }
}
