class Solution {
  public int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length + 1];
    dp[0] = 0;
    dp[1] = cost[0];

    for (int i = 1; i < cost.length; i++) {
      dp[i + 1] = cost[i] + Math.min(dp[i], dp[i - 1]);
    }

    return Math.min(
        dp[dp.length - 1],
        dp[dp.length - 2]);
  }
}
