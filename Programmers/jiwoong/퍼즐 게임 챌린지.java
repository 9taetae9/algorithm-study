class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;

        while(left <= right){
            int mid = (left + right)/2;
            if(isPossible(mid, diffs, times, limit)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    boolean isPossible(int level, int[] diffs, int[] times, long limit){
        long totalTime = 0;
        int prevTime = times[0];

        for (int i = 0; i < diffs.length; i++){
            int curTime = times[i];
            int curDiff = diffs[i];

            if(curDiff <= level){
                totalTime += curTime;
            }else{
                totalTime += (curDiff - level) * (prevTime + curTime) + curTime;
            }

            prevTime = curTime;
            if(limit < totalTime) return false;
        }
        return true;
    }
}