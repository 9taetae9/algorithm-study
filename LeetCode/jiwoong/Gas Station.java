package org.example;

public class Solution{
    public int canCompleteCircuit(int[] gas, int[] cost){
        int totalGas = 0;
        int totalCost = 0;

        for(int i = 0; i<gas.length; i++){
            totalCost += cost[i];
            totalGas += gas[i];
        }

        if(totalGas < totalCost) return -1;

        int leftover = 0;
        int ans = 0;

        for(int i = 0; i<gas.length; i++){
            int diff = gas[i] - cost[i];
            leftover += diff;

            if(leftover < 0)  {
                ans = i + 1;
                leftover = 0;
            }
        }

        return ans;
    }
}
