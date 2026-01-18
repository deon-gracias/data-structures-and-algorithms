// https://leetcode.com/problems/two-sum/description/

import java.util.Arrays;
import java.util.HashMap;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> posMap = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      // x + y = target => target - x = y
      final int x = nums[i];
      final int y = target - x;

      // Does posMap contain the x part
      if (posMap.containsKey(y)) {
        return new int[] { i, posMap.get(y) };
      }

      posMap.put(x, i);
    }

    return new int[] {};
  }
}
