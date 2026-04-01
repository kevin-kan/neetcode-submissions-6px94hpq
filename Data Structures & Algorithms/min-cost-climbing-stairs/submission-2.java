class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];

        // Cost at 3 is equal to:
        // Cost at 2 + min cost at 2
        // Cost at 1 + min cost at 1
        // Therefore:
        // minCost[i] = min( minCost at previous step + the cost of the previous step,
        //                  minCost at 2 steps previous + cost of 2 steps previous)

        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        if (cost.length == 1) return cost[0];

        for (int i = 2; i < minCost.length; i++) {
            minCost[i] = Math.min(  minCost[i-1] + cost[i-1], 
                                    minCost[i-2] + cost[i-2]);
        }

        return minCost[cost.length];
    }
}
