class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;

    int l = 0, r = 1;
    while (l < prices.length && r < prices.length) {
      int buy = prices[l], sell = prices[r];

      if (buy > sell) {
        l = r;
      }

      maxProfit = Math.max(sell - buy, maxProfit);
      r++;
    }

    return maxProfit;
  }
}
