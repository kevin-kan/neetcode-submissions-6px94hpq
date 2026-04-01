class Solution {
    public int climbStairs(int n) {
        // State: dp[i]
        // Recurrence: dp[i] = dp[i-1] + dp[i-2] (climb 1 step from 1 step back, or 2 steps from 2 steps back)
        // Base Case: dp[0] = 1, dp[1] = 1, dp[2] = 2 (1+1 or 2)
        // Order of Computation: 0 or 2 to n
        // Return: dp[n] at the end.

        int[] dp = new int[n+1];

        if (n <= 1) return 1;

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
