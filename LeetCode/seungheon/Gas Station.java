class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int idx = 0;
        int total = 0;
        int cur = 0;

        for (int i = 0; i < gas.length; ++i) {
            int calc = gas[i] - cost[i];
            total += calc;
            cur += calc;

            if (cur < 0) {
                cur = 0;
                idx = i + 1;
            }
        }

        return total < 0 ? -1 : idx;
    }
}
