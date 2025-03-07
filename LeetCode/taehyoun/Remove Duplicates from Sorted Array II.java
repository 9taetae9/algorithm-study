//내 풀이
//newIdx : 새배열 다음 인덱스
//i : 현재 탐색 인덱스
//옮길때 10001로 shift했음을 표시
class Solution {
    public int removeDuplicates(int[] nums) {
        int newIdx = 0;
        for(int i=0; i<nums.length;){
            int temp = nums[i];
            nums[i] = 10001;
            i++;
            nums[newIdx] = temp;
            newIdx++;

            if(i < nums.length && temp == nums[i]){
                nums[i] = 10001;
                i++;
                nums[newIdx] = temp;
                newIdx++;
                if(i >= nums.length) {
                    return newIdx;
                }
                while(i < nums.length && temp == nums[i]) i++;
            }
        }
        return newIdx;
    }
}


//모범 풀이
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        
        int index = 2;

        for (int i = 2; i < nums.length; i++) {
            // 현재 요소가 이미 저장된 두 개의 요소와 다르면 저장
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        
        return index;
    }
}
