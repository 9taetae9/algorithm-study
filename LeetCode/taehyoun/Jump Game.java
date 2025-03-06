//시간 초과 
class Solution {
    public boolean canJump(int[] nums) {
        return backtrack(0, nums);
    }

    private boolean backtrack(int a, int[] nums){
        if(a == nums.length-1) return true;
        if(nums[a] == 0) return false;

        for(int i=1; i<=nums[a]; i++){
            if(a+i >= nums.length) break;
            if(backtrack(a+i, nums)){
                return true;
            }
        }

        return false;
    }
}

// 메모이제이션 적용 (통과)
//기존 백트래킹 O(k^n)에서 O(n*k)로 개선 (n: 배열 길이, k: 최대 점프 거리)
class Solution {
    boolean[] memo;
    public boolean canJump(int[] nums) {
        memo = new boolean[nums.length];
        return backtrack(0, nums);
    }

    private boolean backtrack(int a, int[] nums){
        if(a == nums.length-1) return true;
        if(nums[a] == 0) return false;

        for(int i=1; i<=nums[a]; i++){
            if(a+i >= nums.length) break;
            if(memo[a+i]) continue;

            memo[a+i] = true;
            if(backtrack(a+i, nums)){
                return true;
            } 
        }

        return false;
    }
}

//최적 그리디 O(n)
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;

        int maxPos = 0;

        for(int i=0; i<nums.length; i++){
            
            if(i > maxPos){
                return false;
            }

            maxPos = Math.max(maxPos, i+nums[i]);

            if(maxPos >= nums.length-1) return true;
        }
        return true;
    }
}
