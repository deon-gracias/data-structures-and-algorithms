class Solution {
  public int climbStairs(int n) {
    if (n <= 1)
      return 1;

    int l = 1, sl = 1;
    for (int i = 2; i <= n; i++) {
      int curr = sl + l;

      sl = l;
      l = curr;
    }

    return l;
  }
}
