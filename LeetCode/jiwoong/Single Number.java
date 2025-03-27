public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int sumSet = 0;
        int sumAll = 0;
        for (int num : nums) {
            if (s.add(num)) sumSet += num;
            sumAll += num;
        }
        return 2 * sumSet - sumAll;
    }

}